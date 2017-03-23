package per.liuqh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import per.liuqh.dao.impl.UserMapper;
import per.liuqh.entity.User;
import per.liuqh.serviceapi.service.DemoService;

@Service
public   class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TestService testService;
	@Reference
	private DemoService demoService;
	/*
	@Autowired
	private DemoService demoService;
	
	@Override
	public int addUser(User user) throws Exception {
		int ret=userMapper.insert(user);
		try{
		System.out.println(demoService.sayHello("hello"));
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("调用dubbo服务出错了");
		}
		System.out.println("添加用户成功！");
		return ret;
	}
	*/
	@Override
	public int addUser(User user) throws Exception {
		int ret=userMapper.insert(user);
		try{
			//会回滚
			testService.doSome();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("+++++++++++异常被捕捉了");
		}
		return ret;
	}
	
	

	
	
	@Override
	public int addUser3() throws Exception {
		User u=new User();
		u.setName("kkk123");
		int ret=userMapper.insert(u);
		u.setName("123kkk");
		try{
			addUser4(u);
			//testService.getSome();
			//testService.f2();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("get get get ");
		}
		return ret;
	}
	
	@Override
	public int addUser4(User user) throws Exception {
		int ret=userMapper.insert(user);
	/*	if(1<2){
			//throw new RuntimeException("yyyyyyzzzdddttt");
			throw new Exception("yyyyyyzzzttt");
		}*/
		return ret;
	}


	@Override
	public void test4() throws Exception {
		System.out.println(123123232);
		User u=new User();
		/*u.setName("123liu");
		userMapper.insert(u);*/
		//testService.doSome2();
		
		u.setName("liu123");
		addUser4(u);
		
		/*try{
		if(1<2){
			throw new Exception("yyyyyyzzz111");
		}
		}catch(Exception e){
			System.out.println("dd get dd aaa");
			e.printStackTrace();
		}*/
	}

	@Override
	public void addUser2() throws Exception {
		User u=new User();
		u.setName("liuqh555");
		userMapper.insert(u);
		test5();
	}
	
	@Override
	public void test5() throws Exception {
		User u=new User();
		u.setName("55liuqh");
		userMapper.insert(u);
		if(1<2){
			throw new Exception("zzzzzzdddd");
		}
		
	}
	

}
