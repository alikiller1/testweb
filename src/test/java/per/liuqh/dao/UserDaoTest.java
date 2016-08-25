package per.liuqh.dao;



import net.spy.memcached.MemcachedClient;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.entity.User;
import per.liuqh.memcached.MemcachedService;

public class UserDaoTest extends TestBaseCase{
	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private MemcachedClient memcachedClient;
	@Autowired
	private MemcachedService memcachedService;
	@Test
	public void test1(){
		User user=new User();
		user.setUserId("1");
		user.setPassword("123");
		user.setUsername("liuqh");
		iUserDao.saveUser(user);
		System.out.println(iUserDao.getById("1"));
		//iUserDao.deleteUser("1");
		//iUserDao.updateUser(user);
		
	}
	@Test
	public void test2(){
		//System.out.println(iUserDao.getById("1"));
		//memcachedClient.set("name", 0, "liuqh");
		//System.out.println(memcachedService.getObject("ns:1"));
		//System.out.println(System.currentTimeMillis());
		//System.out.println(memcachedClient.get("name"));
		System.out.println(memcachedClient.get("SERVER_PRIVATE_KEY"));
		
	}
	
	
}
