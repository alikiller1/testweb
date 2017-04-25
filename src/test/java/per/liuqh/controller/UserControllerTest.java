package per.liuqh.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;

public class UserControllerTest extends TestBaseCase{
	@Autowired
	private UserController userController;
	
	@Test
	public void test1(){
		request.setParameter("name", "abcfff");
		userController.add(request,response);
	}
}
