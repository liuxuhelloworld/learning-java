package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitPairManager1 extends PairManager {
	private Lock lock = new ReentrantLock();

	public synchronized void increment() {
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			store(getPair());
		} finally {
			lock.unlock();
		}
	}
}

class ExplicitPairManager2 extends PairManager {
	private Lock lock = new ReentrantLock();

	public void increment() {
		Pair tmp;

		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			tmp = getPair();
		} finally {
			lock.unlock();
		}

		store(tmp);
	}
}

public class ExplicitCriticalSection {
	public static void main(String[] args) {
		PairManager pman1 = new ExplicitPairManager1(), pman2 = new ExplicitPairManager2();

		CriticalSection.testApproaches(pman1, pman2);
	}
}
