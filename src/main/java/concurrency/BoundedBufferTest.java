package concurrency;

import junit.framework.TestCase;

public class BoundedBufferTest extends TestCase {
	private static final long LOCKUP_DETECT_TIMEOUT = 1000L;

	public void testIsEmptyWhenConstructed() {
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(10);
		assertTrue(buffer.isEmpty());
		assertFalse(buffer.isFull());
	}

	public void testIsFullAfterPuts() throws InterruptedException {
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(10);
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
		}

		assertTrue(buffer.isFull());
		assertFalse(buffer.isEmpty());
	}

	public void testTakeBlocksWhenEmpty() {
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(10);

		Thread taker = new Thread(() -> {
			try {
				buffer.take();
				fail();
			} catch (InterruptedException e) {
				System.out.println("test succeed");
			}
		});

		try {
			taker.start();
			Thread.sleep(LOCKUP_DETECT_TIMEOUT);
			taker.interrupt();
			taker.join(LOCKUP_DETECT_TIMEOUT);
			assertFalse(taker.isAlive());
		} catch (Exception e) {
			fail();
		}
	}
}
