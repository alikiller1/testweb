package per.liuqh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.liuqh.dao.UserMapper;
import per.liuqh.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public int addUser(User user) throws Exception {
		int ret=userMapper.insert(user);
		int a=1/0;
		return ret;
	}
	
}
