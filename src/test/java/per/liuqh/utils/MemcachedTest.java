package per.liuqh.utils;

import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.dao.IUserInfoDao;
import per.liuqh.entity.UserInfo;
import per.liuqh.memcached.MemcachedUtils;

public class MemcachedTest extends TestBaseCase {
	private final static Object lock=new Object();
	@Autowired
	private IUserInfoDao userDao;
	@Autowired
	private MemcachedClient memcachedClient;
	@Autowired
	private MemcachedUtils memcachedUtils;

	@Test
	public void test1() {
		UserInfo user = new UserInfo();
		user.setUserId("2");
		user.setPassword("123");
		user.setUsername("liuqh");
		userDao.saveUser(user);
		userDao.updateUser(user);
		System.out.println(userDao.getById(user.getUserId()));

	}

	@Test
	public void test2() {
		System.out.println(userDao.getById("2"));
		// System.out.println(userDao.getById("2"));
		// memcachedClient.set("name", 0, "liuqh");
		System.out.println(memcachedUtils.getObject("userinfo:2"));
		// System.out.println(memcachedClient.get("name"));
		// System.out.println(memcachedClient.get("SERVER_PRIVATE_KEY"));

	}

	@Test
	public void test4() {
		UserInfo user = new UserInfo();
		user.setUserId("1");
		user.setPassword("234");
		user.setUsername("liuqh");
		userDao.updateUser(user);
	}

	@Test
	public void test3() {
		// memcachedClient.set("abc", 5, "abc_abc");
		System.out.println(memcachedClient.get("abc"));
		System.out.println(userDao.getDateString("start"));
		System.out.println(memcachedClient.get("key:start"));
		System.out.println(System.currentTimeMillis() / 1000);
	}

	@Test
	public void test6() {
		System.out.println(userDao.getAssignStrings());
	}

	@Test
	public void test7() throws InterruptedException {
		memcachedUtils.put("test:abc", "0dddd", 1000000);
	}

	@Test
	public void test8() {
		System.out.println("end result=" + memcachedUtils.get("test:abc"));
	}
	
	@Test
	public void test9() throws InterruptedException {
		new Thread(){public void run() {
			synchronized (lock) {
				System.out.println("start");
				try {
					lock.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end");
			}
		};}.start();
		
		Thread.sleep(1);
		
		/*Thread.sleep(5000);
		System.out.println("dddddd");*/
		
		synchronized (lock) {
			Thread.sleep(5000);
			System.out.println("dddddd");
		}
		
		
	}

}



   
