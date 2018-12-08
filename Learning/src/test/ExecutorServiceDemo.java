package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1 implements Runnable {
	@Override
	public void run() {
		Thread.currentThread().setName("Task1 thread");
		String threadName1 = Thread.currentThread().getName();
		try {
			System.out.println("Before sleep, inside thread" + threadName1);
			TimeUnit.SECONDS.sleep(1);
			System.out.println("After sleep, inside thread" + threadName1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Task2{
	Runnable task2 =()->{
		Thread.currentThread().setName("Task2 thread2");
		String threadName2 = Thread.currentThread().getName();
		System.out.println("Before sleep, inside thread" + threadName2);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After sleep, inside thread" + threadName2);
	};
}

public class ExecutorServiceDemo {
	public static void main(String[] args) {
		//Fixed thread, so only one thread is running executing the tasks sequentially
		//ExecutorService exe = Executors.newSingleThreadExecutor();
		//Creating thread pool below
		ExecutorService exe = Executors.newFixedThreadPool(2);
		// Creating the submit action
		exe.submit(new Thread(new Task1()));
		exe.submit(new Task2().task2);
		// initiating shutdown
		try {
			System.out.println("Shutdown initiated");
			exe.shutdown();
			exe.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Shutdown process was interrupted");
		} finally {
			exe.shutdownNow();
		}

	}
}
