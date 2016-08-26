package per.liuqh.dao;

import java.util.List;

import per.liuqh.entity.UserInfo;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;


public interface IUserInfoDao {
	public void saveUser(UserInfo user);
	public UserInfo getById(@ParameterValueKeyProvider String userId);
	public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent UserInfo user);
	public void deleteUser(@ParameterValueKeyProvider String userId);
	public String getDateString(@ParameterValueKeyProvider final String key);
	public Object getObject();
	public List<String> getAssignStrings();
}
