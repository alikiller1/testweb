package per.liuqh.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.dao.impl.UserMapper;
import per.liuqh.entity.User;
import per.liuqh.entity.UserExample;

public class UserMapperTest extends TestBaseCase{
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test1(){
		User u=userMapper.selectByPrimaryKey(1);
		System.out.println(u);
		
		System.out.println(userMapper.countByExample(new UserExample()));
	}
}
