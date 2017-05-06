package per.liuqh.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;



public class StudentServiceTest extends TestBaseCase {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void test1(){
		studentService.dof1("abc123");
	}
	
	@Test
	public void test2() throws Exception{
		studentService.add("abc1234");
	}

}
