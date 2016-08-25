package per.liuqh.common.memcached;

import net.spy.memcached.MemcachedClient;
import per.liuqh.common.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MemcachedServiceImpl implements MemcachedService {

	private static final Logger logger = LoggerFactory.getLogger(MemcachedServiceImpl.class);
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	private Integer cacheExpiredTime=3000;
	
	@Override
	public void put(String key, String json){
		int expiredTime = 3000;
		if (cacheExpiredTime == null) {
			expiredTime = cacheExpiredTime.intValue();
		}
		put(key, json, expiredTime);
	}
	
	@Override
	public void put(String key, String json, int expiredTime){
		try {
			if (StringUtils.isBlank(key) || StringUtils.isBlank(json)) {
				throw new IllegalArgumentException("memcached required key and value not blank");
			}
			if (memcachedClient.add(key, expiredTime, json).isDone()) {
				memcachedClient.set(key, expiredTime, json);
			}
		} catch (IllegalArgumentException e) {
			logger.error("Memcached server 异常", e);
		}
	}
	
	@Override
	public String get(String key) {
		try{
		return (String)memcachedClient.get(key);
		}catch(Exception e){
			logger.error("Memcached server 异常", e);
			return null;
		}
		
	}
	
	@Override
	public void refreshExpiredTime(String key, int expiredTime) {
			memcachedClient.touch(key,expiredTime);
	}
	
	@Override
	public void del(String key) {
		memcachedClient.delete(key);
	}

	@Override
	public Object getObject(String key) {
		try{
		return memcachedClient.get(key);
		}catch(Exception e){
			logger.error("Memcached server 异常", e);
			return null;
		
		}
	}


	
}
