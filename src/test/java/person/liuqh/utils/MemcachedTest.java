package person.liuqh.utils;

import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.common.memcached.MemcachedService;
import per.liuqh.dao.IUserInfoDao;
import per.liuqh.entity.UserInfo;

public class MemcachedTest extends TestBaseCase {
	@Autowired
	private IUserInfoDao userDao;
	@Autowired
	private MemcachedClient memcachedClient;
	@Autowired
	private MemcachedService memcachedService;

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
		 //System.out.println(userDao.getById("2"));
		// memcachedClient.set("name", 0, "liuqh");
		 System.out.println(memcachedService.getObject("userinfo:2"));
		// System.out.println(memcachedClient.get("name"));
		System.out.println(memcachedClient.get("SERVER_PRIVATE_KEY"));

	}
	@Test
	public void test4(){
		UserInfo user = new UserInfo();
		user.setUserId("1");
		user.setPassword("234");
		user.setUsername("liuqh");
		userDao.updateUser(user);
	}
	@Test
	public void test3(){
		//memcachedClient.set("abc", 5, "abc_abc");
		System.out.println(memcachedClient.get("abc"));
		System.out.println(userDao.getDateString("start"));
		System.out.println(memcachedClient.get("key:start"));
	}
	
	@Test
	public void test6(){
		System.out.println(userDao.getAssignStrings());
	}
	
}
