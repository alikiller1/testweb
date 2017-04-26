package per.liuqh.activemq;

 
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;
 

@Component
public class QueueReceiver implements MessageListener {
 
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("QueueReceiver1接收到消息:"+((TextMessage)message).getText());
            if(1<2){
            	 throw new RuntimeException("测试异常");
            }
           
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
 
}