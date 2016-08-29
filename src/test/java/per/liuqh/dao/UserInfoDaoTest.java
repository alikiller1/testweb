package per.liuqh.dao;

import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.common.memcached.MemcachedService;
import per.liuqh.entity.UserInfo;

public class UserInfoDaoTest extends TestBaseCase {
	@Autowired
	private IUserInfoDao userDao;
	@Autowired
	private MemcachedClient memcachedClient;
	@Autowired
	private MemcachedService memcachedService;

	@Test
	public void test1() {
		UserInfo user = new UserInfo();
		user.setUserId("21");
		user.setPassword("123");
		user.setUsername("liuqh");
		userDao.saveUser(user);
		//userDao.updateUser(user);
		System.out.println(userDao.getById(user.getUserId()));

	}
	
	@Test
	public void test2() {
		 //System.out.println(userDao.getById("2"));
		// memcachedClient.set("name", 0, "liuqh");
		 System.out.println(memcachedService.getObject("userinfo:21"));
		 System.out.println(System.currentTimeMillis());
		// System.out.println(memcachedClient.get("name"));
		//System.out.println(memcachedClient.get("SERVER_PRIVATE_KEY"));

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
		System.out.println(userDao.getDateString("start"));
	}
	
	@Test
	public void test5(){
		System.out.println(userDao.getObject());
	}
	
	@Test
	public void test6(){
		System.out.println(userDao.getAssignStrings());
	}
	
	@Test
	public void test7(){
		System.out.println(userDao.getAssignStrings());
	}
	
	
}
