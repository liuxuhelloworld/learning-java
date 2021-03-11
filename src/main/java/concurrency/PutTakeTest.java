package concurrency;

import junit.framework.TestCase;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PutTakeTest extends TestCase {
	private static final ExecutorService pool = Executors.newCachedThreadPool();
	private final BoundedBuffer<Integer> buffer;
	private final int nPairs, nTrials;
	private final CyclicBarrier barrier;
	private final AtomicInteger putSum = new AtomicInteger(0);
	private final AtomicInteger takeSum = new AtomicInteger(0);

	public PutTakeTest(int capacity, int nPairs, int nTrials) {
		this.buffer = new BoundedBuffer<>(capacity);
		this.nPairs = nPairs;
		this.nTrials = nTrials;
		this.barrier = new CyclicBarrier(nPairs * 2 + 1);
	}

	private void test() {
		try {
			for (int i = 0; i < nPairs; i++) {
				pool.execute(new Producer());
				pool.execute(new Consumer());
			}
			barrier.await(); // wait for all threads to be ready
			barrier.await(); // wait for all threads to finish
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

	public static void main(String[] args) {
		new PutTakeTest(10, 10, 100000).test();
		pool.shutdown();
	}
}
