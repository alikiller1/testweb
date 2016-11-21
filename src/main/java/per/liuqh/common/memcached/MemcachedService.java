package per.liuqh.common.memcached;



public interface MemcachedService {

	void put(String key, String json, int expiredTime);

	String get(String key);
	
	Object getObject(String key);

	void refreshExpiredTime(String key, int expiredTime);

	void del(String key);

}