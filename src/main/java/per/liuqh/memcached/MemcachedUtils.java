package per.liuqh.memcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.spy.memcached.MemcachedClient;
import per.liuqh.common.utils.StringUtils;

@Component
public class MemcachedUtils{

	private  final Logger logger = LoggerFactory.getLogger(MemcachedUtils.class);
	
	@Autowired
	private  MemcachedClient memcachedClient;
	
	public  void put(String key, String json, int expiredTime){
		try {
			if (StringUtils.isBlank(key) || StringUtils.isBlank(json)) {
				throw new IllegalArgumentException("memcached required key and value not blank");
			}
				memcachedClient.set(key, expiredTime, json);
		} catch (IllegalArgumentException e) {
			logger.error("Memcached server 异常", e);
		}
	}
	
	public  String get(String key) {
		try{
		Object o=memcachedClient.get(key);
		return (String)o;
		}catch(Exception e){
			logger.error("Memcached server 异常", e);
			return null;
		}
		
	}
	
	public  void del(String key) {
		memcachedClient.delete(key);
	}

	public  Object getObject(String key) {
		try{
		Object o= memcachedClient.get(key);
		return o;
		}catch(Exception e){
			logger.error("Memcached server 异常", e);
			return null;
		
		}
	}
	
}
