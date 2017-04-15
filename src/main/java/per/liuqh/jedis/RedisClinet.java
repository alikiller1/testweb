package per.liuqh.jedis;

import redis.clients.jedis.Jedis;

public class RedisClinet {
    private static final String ip= "192.168.204.128";
    private static final int port=6385;
    protected static RedisClinet redis = new RedisClinet ();
    protected static Jedis jedis = new Jedis( ip, port);;
    static {
         
   }
  protected RedisClinet(){
     System. out.println( " init Redis ");
  }
  public static RedisClinet getInstance()
  {
      return redis;
  }
 
  /**set Object*/
    public String set(Object object,String key)
   {
          return jedis.set(key.getBytes(), SerializeUtil.serialize(object));
   }
   
    /**get Object*/
    public Object get(String key)
   {
          byte[] value = jedis.get(key.getBytes());
          return SerializeUtil. unserialize(value);
   }
   
    /**delete a key**/
    public boolean del(String key)
   {
          return jedis.del(key.getBytes())>0;
   }

}
