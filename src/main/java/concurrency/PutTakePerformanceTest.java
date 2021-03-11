package concurrency;

import junit.framework.TestCase;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PutTakePerformanceTest extends TestCase {
	private static final ExecutorService pool = Executors.newCachedThreadPool();
	private final BoundedBuffer<Integer> buffer;
	private final int nPairs, nTrials;
	private final BarrierTimer timer;
	private final CyclicBarrier barrier;
	private final AtomicInteger putSum = new AtomicInteger(0);
	private final AtomicInteger takeSum = new AtomicInteger(0);

	public PutTakePerformanceTest(int capacity, int nPairs, int nTrials) {
		this.buffer = new BoundedBuffer<>(capacity);
		this.nPairs = nPairs;
		this.nTrials = nTrials;
		this.timer = new BarrierTimer();
		this.barrier = new CyclicBarrier(nPairs * 2 + 1, timer);
	}

	public void test() {
		try {
			timer.clear();
			for (int i = 0; i < nPairs; i++) {
				pool.execute(new Producer());
				pool.execute(new Consumer());
			}
			barrier.await(); // wait for all threads to be ready
			barrier.await(); // wait for all threads to finish

			long nsPerItem = timer.getTime() / (nPairs * nTrials);
			System.out.print("Throughput: " + nsPerItem + " ns/item");

			assertEquals(putSum.get(), takeSum.get());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private class Producer implements Runnable {
		@Override
		public void run() {
			try {
				int seed = (this.hashCode() ^ (int)System.nanoTime());
				int sum = 0;
				barrier.await();
				for (int i = nTrials; i > 0; i--) {
					buffer.put(seed);
					sum += seed;
					seed = xorShift(seed);
				}
				putSum.getAndAdd(sum);
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	private class Consumer implements Runnable {
		@Override
		public void run() {
			try {
				int sum = 0;
				barrier.await();
				for (int i = nTrials; i > 0; i--) {
					sum += buffer.take();
				}
				takeSum.getAndAdd(sum);
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static int xorShift(int y) {
		y ^= (y << 6);
		y ^= (y >>> 21);
		y ^= (y << 7);
		return y;
	}

	public static void main(String[] args) throws InterruptedException {
		int tpt = 1000;

		for (int cap = 1; cap <= 1000; cap *= 10) {
			System.out.println("Capacity: " + cap);
			for (int pairs = 1; pairs <= 128; pairs *= 2) {
				PutTakePerformanceTest t = new PutTakePerformanceTest(cap, pairs, tpt);
				System.out.print("Pairs: " + pairs + "\t");
				t.test();
				System.out.print("\t");
				Thread.sleep(1000);
				t.test();
				System.out.println();
				Thread.sleep(1000);
			}
		}
		pool.shutdown();
	}
}
