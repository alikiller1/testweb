package per.liuqh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.liuqh.dao.impl.UserMapper;
import per.liuqh.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
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
		addUser2(user);
		}catch(Exception e){
			System.out.println("+++++++++++异常被捕捉了");
		}
		System.out.println("+++++++++++异常未补捕捉");
		return ret;
	}
	@Override
	public int addUser2(User user) throws Exception {
		int ret=userMapper.insert(user);
		if(1<2) throw new Exception("+++++++++++测试异常");
		return ret;
	}
	
}
