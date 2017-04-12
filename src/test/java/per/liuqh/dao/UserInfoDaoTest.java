package per.liuqh.dao;

import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.entity.UserInfo;
import per.liuqh.memcached.MemcachedUtils;

public class UserInfoDaoTest extends TestBaseCase {
	@Autowired
	private IUserInfoDao userDao;
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

	
	
}
