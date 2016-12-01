package per.liuqh.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public void doSome()throws Exception{
		throw new Exception("--------------------------测试异常");
	}
}
