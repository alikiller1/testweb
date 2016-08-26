package per.liuqh.dao;

import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.common.memcached.MemcachedService;
import per.liuqh.entity.User;

public class UserDaoTest extends TestBaseCase {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private MemcachedClient memcachedClient;
	@Autowired
	private MemcachedService memcachedService;

	@Test
	public void test1() {
		User user = new User();
		user.setUserId("1");
		user.setPassword("123");
		user.setUsername("liuqh");
		userDao.saveUser(user);
		System.out.println(userDao.getById("1"));
		// iUserDao.deleteUser("1");
		// iUserDao.updateUser(user);

	}

	@Test
	public void test2() {
		 System.out.println(userDao.getById("1"));
		// memcachedClient.set("name", 0, "liuqh");
		// System.out.println(memcachedService.getObject("ns:1"));
		// System.out.println(System.currentTimeMillis());
		// System.out.println(memcachedClient.get("name"));
		//System.out.println(memcachedClient.get("SERVER_PRIVATE_KEY"));

	}
	@Test
	public void test3(){
		System.out.println(userDao.getDateString("start"));
	}

}
