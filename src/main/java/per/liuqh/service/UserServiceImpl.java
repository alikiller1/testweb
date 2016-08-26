package per.liuqh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.liuqh.dao.impl.UserMapper;
import per.liuqh.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public int addUser(User user) throws Exception {
		int ret=userMapper.insert(user);
		return ret;
	}
	
}
