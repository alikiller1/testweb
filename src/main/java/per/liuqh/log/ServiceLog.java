package per.liuqh.log;

public class ServiceLog{  
    //在类里面写方法，方法名诗可以任意的。此处我用标准的before和after来表示  
   public void before(){  
             System.out.println("被拦截方法调用之前调用此方法，输出此语句");  
   }  
   public void after(){  
               System.out.println("被拦截方法调用之后调用此方法，输出此语句");  
   }  
}  