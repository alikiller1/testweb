package per.liuqh.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(50000);
		//TimeUnit.MILLISECONDS,
       // new LinkedBlockingQueue<Runnable>()
		//ExecutorService pool=Executors.newFixedThreadPool(2);
		int count=0;
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2000, 20000, 50, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		for(int i=0;i<2000000;i++){
			pool.execute(new Thread(){
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId());
				}
			});
			count++;
		}
		System.out.println(count);
		pool.shutdown();
		/*pool.execute(new Thread(){
			@Override
			public void run() {
				System.out.println("--------------");
			}
		});*/
	}
}
