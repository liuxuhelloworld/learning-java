package concurrency;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.Semaphore;

@ThreadSafe
public class BoundedBuffer<E> {
	private final Semaphore availableItems, availableSpaces;

	@GuardedBy("this")
	private final E[] items;

	@GuardedBy("this")
	private int putPosition = 0, takePosition = 0;

	public BoundedBuffer(int capacity) {
		availableItems = new Semaphore(0);
		availableSpaces = new Semaphore(capacity);
		items = (E[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return availableItems.availablePermits() == 0;
	}

	public boolean isFull() {
		return availableSpaces.availablePermits() == 0;
	}

	public void put(E x) throws InterruptedException {
		availableSpaces.acquire();
		doInsert(x);
		availableItems.release();
	}

	public E take() throws InterruptedException {
		availableItems.acquire();
		E x = doExtract();
		availableSpaces.release();
		return x;
	}

	private synchronized void doInsert(E x) {
		int i = putPosition;
		items[i] = x;
		putPosition = (++i == items.length) ? 0 : i;
	}

	private synchronized E doExtract() {
		int i = takePosition;
		E x = items[i];
		items[i] = null; // this is one of the few times where explicit nulling is necessary
		takePosition = (++i == items.length) ? 0 : i;
		return x;
	}
}
