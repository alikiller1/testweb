package per.liuqh.log;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.controller.TestController;
import per.liuqh.service.StudentService;

public class LogTest extends TestBaseCase{
	@Autowired
	private StudentService service1;
	@Autowired
	private TestController testController;
	@Test
	public void test1(){
		service1.testLog();
	}
	
	@Test
	public void test2(){
		request.setParameter("name", "liuqh");
		String resp=testController.testLog(request,response);
		System.out.println("resp----->"+resp);
	}
	
	
}
