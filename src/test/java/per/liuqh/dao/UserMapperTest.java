package per.liuqh.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.dao.impl.UserMapper;
import per.liuqh.entity.User;

public class UserMapperTest extends TestBaseCase{
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test1(){
		User u=userMapper.findUserInfo(1);
		System.out.println(u);
	}
}
