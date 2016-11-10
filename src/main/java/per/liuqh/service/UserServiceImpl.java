package per.liuqh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.liuqh.dao.impl.UserMapper;
import per.liuqh.entity.User;
import per.liuqh.testdubbo.DemoService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private DemoService demoService;
	/*
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
		return ret;
	}
	
}
