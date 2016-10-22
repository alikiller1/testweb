package per.liuqh.dao.impl;

import per.liuqh.entity.User;

public interface UserMapper {
	public User findUserInfo(int id);
	
	public Integer insert(User u);
}
