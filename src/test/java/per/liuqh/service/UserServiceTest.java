package per.liuqh.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.entity.User;

public class UserServiceTest extends TestBaseCase {
	@Autowired
	private UserService userService;
	
	@Test
	public void test1() throws Exception{
		User u=new User();
		u.setName("aaa");
		System.out.println(userService.addUser2(u));
	}
}
