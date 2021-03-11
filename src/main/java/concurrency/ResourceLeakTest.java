package concurrency;

import junit.framework.TestCase;

public class ResourceLeakTest extends TestCase {
	private static final int CAPACITY = 100;

	public void testLeak() throws InterruptedException {
		BoundedBuffer<Big> buffer = new BoundedBuffer<>(CAPACITY);

		long heapSize1 = Runtime.getRuntime().freeMemory();

		for (int i = 0; i < CAPACITY; i++) {
			buffer.put(new Big());
		}

		for (int i = 0; i < CAPACITY; i++) {
			buffer.take();
		}

		System.gc();

		long heapSize2 = Runtime.getRuntime().freeMemory();

		System.out.println(Math.abs(heapSize1 - heapSize2));
	}

	private static class Big {
		double[] data = new double[100000];
	}
}
