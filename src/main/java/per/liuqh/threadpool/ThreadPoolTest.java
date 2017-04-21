package per.liuqh.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		test2();
	}
	
	public static void test1() throws InterruptedException{

		Thread.sleep(50000);
		//TimeUnit.MILLISECONDS,
       // new LinkedBlockingQueue<Runnable>()
		//ExecutorService pool=Executors.newFixedThreadPool(2);
		int count=0;
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 20000, 50, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		for(int i=0;i<10;i++){
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
		//纯种池调了shutdown之后，就不能再添加新的任务了
		/*pool.execute(new Thread(){
			@Override
			public void run() {
				System.out.println("--------------");
			}
		});*/
	}
	
	public static void test2() throws InterruptedException{
		ThreadPool pool=ThreadPool.getInstance();
		int count=0;
		for(int i=0;i<100;i++){
			pool.addTask(new Task() {
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId());
					super.run();
				}

				@Override
				public Task[] taskCore() throws Exception {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				protected boolean useDb() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				protected boolean needExecuteImmediate() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public String info() {
					// TODO Auto-generated method stub
					return null;
				}
			
			});
			count++;
		}
		System.out.println(count);
		Thread.sleep(200000);
		//pool.destroy();
		
		
	}
}
