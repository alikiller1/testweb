package per.liuqh.dao;

import per.liuqh.entity.User;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;


public interface IUserDao {
	public void saveUser(User user);
	public User getById(@ParameterValueKeyProvider String userId);
	public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent User user);
	public void deleteUser(@ParameterValueKeyProvider String userId);
}
