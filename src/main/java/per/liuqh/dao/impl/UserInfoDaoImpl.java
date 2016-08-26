package per.liuqh.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import per.liuqh.dao.IUserInfoDao;
import per.liuqh.entity.UserInfo;

import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughAssignCache;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;

@Repository
public class UserInfoDaoImpl implements IUserInfoDao {
	private static final String NAMESPACE="userinfo";
	private Map<String,UserInfo> users=new HashMap<String,UserInfo>();
	@Override
	public void saveUser(UserInfo user) {
		users.put(user.getUserId(), user);
	}
	/**
	 * 当执行getById查询方法时，系统首先会从缓存中获取userId对应的实体
	 * 如果实体还没有被缓存，则执行查询方法并将查询结果放入缓存中
	 */
	@Override
	@ReadThroughSingleCache(namespace = NAMESPACE, expiration =3600)
	public UserInfo getById(@ParameterValueKeyProvider String userId) {
		System.out.println("没有命中，userId="+userId);
		return users.get(userId);
	}
	/**
	 * 当执行updateUser方法时，系统会更新缓存中userId对应的实体
	 * 将实体内容更新成@*DataUpdateContent标签所描述的实体
	 */
	@UpdateSingleCache(namespace = NAMESPACE, expiration =3600)
	@Override
	public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent UserInfo user) {
		users.put(user.getUserId(), user);
	}
	/**
	 * 当执行deleteUser方法时，系统会删除缓存中userId对应的实体
	 */
	@InvalidateSingleCache(namespace = NAMESPACE)
	@Override
	public void deleteUser(@ParameterValueKeyProvider String userId) {
		users.remove(userId);
	}
	
	@ReadThroughSingleCache(namespace = "key", expiration = 3600)  
    public String getDateString(@ParameterValueKeyProvider final String key) {  
        final Date now = new Date();  
        try {  
            Thread.sleep(1500);  
        } catch (InterruptedException ex) {  
        }  
        return now.toString() + ":" + now.getTime();  
    }
	
	@ReadThroughAssignCache(assignedKey = "1", namespace = "userinfo", expiration = 3600)
	@Override
	public Object getObject() {
		System.out.println("没有命中");
		return users.get("1");
	}  
	
	@ReadThroughAssignCache(assignedKey = "aaa", namespace = "userinfo", expiration = 3000)  
    public List<String> getAssignStrings() {  
		System.out.println("没有命中");
        try {  
            Thread.sleep(500);  
        } catch (InterruptedException ex) {  
        }  
        final List<String> results = new ArrayList<String>();  
        final long extra = System.currentTimeMillis() % 20;  
        final String base = System.currentTimeMillis() + "";  
        for (int ix = 0; ix < 20 + extra; ix++) {  
            results.add(ix + "-" + base);  
        }  
        return results;  
    }  
	
}
