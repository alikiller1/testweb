package per.liuqh.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.entity.User;

public class UserServiceTest extends TestBaseCase {
	@Autowired
	private UserService userService;
	
	
	@Test
	public void test2() throws Exception{
		userService.test4();
	}

	@Test
	public void test3() throws Exception{
		userService.addUser3();
	}
	
	@Test
	public void test4() throws Exception{
		userService.addUser2();
	}
}
