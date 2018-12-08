package test;

import java.util.concurrent.TimeUnit;

public class RunnableDemo {
	static Runnable runnable = () ->{
		String threadName = Thread.currentThread().getName();
		try {
			System.out.println("Before sleep, inside thread" + threadName);
			TimeUnit.SECONDS.sleep(1);
			System.out.println("After sleep, inside thread" + threadName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static void main(String[] args) {
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
