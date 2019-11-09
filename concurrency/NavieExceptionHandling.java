package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class NavieExceptionHandling {
	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		} catch (RuntimeException e) {
			System.out.println("exception has been handled");
		}
	}
}
