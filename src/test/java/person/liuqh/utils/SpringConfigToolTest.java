package person.liuqh.utils;

import org.junit.Test;

import per.liuqh.common.TestBaseCase;
import per.liuqh.common.utils.SpringConfigTool;
import per.liuqh.service.OrderService;


public class SpringConfigToolTest extends TestBaseCase  {
	@Test
	public void testGetBean(){
		OrderService o=(OrderService)SpringConfigTool.getBean("orderServiceImpl");
		System.out.println("========orderServiceImpl="+o);
	}
}
