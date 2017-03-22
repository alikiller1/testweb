package per.liuqh.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public void doSome()throws Exception{
		throw new Exception("--------------------------测试异常");
	}
	
	public void doSome2()throws Exception{
	}
	
	public void getSome()throws Exception{
		throw new Exception("--------------------------Exception");
	}
	
	public void f2(){
		throw new RuntimeException("--------RuntimeException");
	}
}
