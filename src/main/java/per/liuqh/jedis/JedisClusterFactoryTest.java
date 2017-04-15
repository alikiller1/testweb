package per.liuqh.jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
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
		System.out.println(cluster);
		
	}
	@Test
	public void test2() throws Exception{
		JedisCluster cluster=jedisClusterFactory.getObject();
		cluster.expire("name", 10);
		
	}

}
