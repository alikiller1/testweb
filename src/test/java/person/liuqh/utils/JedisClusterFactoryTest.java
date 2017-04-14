package person.liuqh.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.jedis.JedisClusterFactory;
import redis.clients.jedis.JedisCluster;

public class JedisClusterFactoryTest extends TestBaseCase {
	@Autowired
	private JedisClusterFactory jedisClusterFactory;
	
	@Test
	public void test1() throws Exception{
		JedisCluster cluster=jedisClusterFactory.getObject();
		  //-----添加数据----------  
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        cluster.hmset("user",map);
        List<String> rsmap = cluster.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);  
		
	}

}
