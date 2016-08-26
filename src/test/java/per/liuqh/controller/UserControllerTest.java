package per.liuqh.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase2;

public class UserControllerTest extends TestBaseCase2{
	@Autowired
	private UserController userController;
	
	@Test
	public void test1(){
		request.setParameter("name", "abcfff");
		userController.add(request,response);
	}
}
