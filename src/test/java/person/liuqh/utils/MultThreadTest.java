package person.liuqh.utils;

public class MultThreadTest {
	public AAA a=new AAA();
	public  void f() {
		System.out.println(Thread.currentThread().getName() + "-->id=" + a.id);
		a.id = a.id + 1;
	}

	public static void main(String[] args) {
		final MultThreadTest o=new MultThreadTest();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					o.f();
				}
			}).start();
		}
		
	}
}

class AAA {
	public int id;
}