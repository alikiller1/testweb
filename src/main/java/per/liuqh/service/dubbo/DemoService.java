package per.liuqh.service.dubbo;

import java.util.List;

import per.liuqh.dubbo.entity.User;


public interface DemoService {  
  
    String sayHello(String name);  
  
    public List<User> getUsers();  
    
    public void test3()throws Exception;
    
    public void doTest()throws Exception;
  
}  