package per.liuqh.serviceapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.dao.impl.UserMapper;
import per.liuqh.serviceapi.entity.User;

@org.springframework.stereotype.Service  
//@Service(timeout=200000,actives=1)
public class DemoServiceImpl implements DemoService{  
	 @Autowired
	 UserMapper userDao;
	 @Autowired
	private UserMapper userMapper;
      
     public String sayHello(String name) {  
    	 	try {
    	 		System.out.println("start------------->"+new Date());
				Thread.sleep(5000);
				System.out.println("end------------->"+new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            return "Hello " + name;  
     }  
     public List<User> getUsers() {  
         List<User> list = new ArrayList<User>();  
         User u1 = new User();  
         u1.setName("jack");  
         u1.setAge(20);  
         u1.setSex("男");  
           
         User u2 = new User();  
         u2.setName("tom");  
         u2.setAge(21);  
         u2.setSex("女");  
           
         User u3 = new User();  
         u3.setName("rose");  
         u3.setAge(19);  
         u3.setSex("女");  
           
         list.add(u1);  
         list.add(u2);  
         list.add(u3);  
         return list;  
     }
     
	@Override
	public void test3() throws Exception {
		if(1<2){
			throw new Exception("test ----test");
		}
		
	}
	@Override
	public void doTest() throws Exception {
		per.liuqh.entity.User u=new per.liuqh.entity.User();
		u.setName("zzzkkk");
		userDao.insert(u);
		if(1<2){
			throw new RuntimeException("test ----test");
		}
		/*if(1<2){
			throw new Exception("test ---dddd----test");
		}*/
	}  
}  
