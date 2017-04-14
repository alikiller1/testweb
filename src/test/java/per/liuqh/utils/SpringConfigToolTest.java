package per.liuqh.utils;

import org.junit.Test;

import per.liuqh.common.TestBaseCase;
import per.liuqh.common.utils.SpringConfigTool;
import per.liuqh.service.UserService;


public class SpringConfigToolTest extends TestBaseCase  {
	@Test
	public void testGetBean(){
		UserService o=(UserService)SpringConfigTool.getBean("userServiceImpl");
		System.out.println("========UserService="+o);
	}
}
