package per.liuqh.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestConcurrent {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();

		// future用于得到任务执行完之后的返回 值
		Future<Person> future = threadPool.submit(new Callable<Person>() {
			/**
			 * 回调方法
			 */
			@Override
			public Person call() throws Exception {

				Person p = new Person("小小", 22);
				return p;
			}
		});

		try {
			// 得到线程结束后返回的结果
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ======================================================

		// 创建一个线程池，该线程池中有3个 线程
		ExecutorService threadPool2 = Executors.newFixedThreadPool(3);

		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);

		// 提交10个任务
		for (int i = 0; i < 10; i++) {
			final int value = i;
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					// Thread.sleep(1000);
					return value;
				}
			});
		}

		try {
			// 得到线程执行完之后的结果，那个线程任务先执行完就先返回，因为提交了10个任务
			// 所以得到的时候也要分10次得到
			for (int i = 0; i < 5; i++) {
				System.out.println(completionService.take().get());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}

class Person {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String name, Integer age) {

		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
