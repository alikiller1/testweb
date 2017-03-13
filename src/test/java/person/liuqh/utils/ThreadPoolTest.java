package person.liuqh.utils;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
		for (int i = 0; i < 20; i++) {
			pool.submit(new MyThread());
		}
		//System.out.println("task-" + pool.getTaskCount());
		//System.out.println("active-" + pool.getActiveCount());
		pool.shutdown();
		System.out.println("----------------");

	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
