package per.liuqh.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
/**
 * <b>function:</b> 消息接收者
 * @author hoojo
 * @createDate 2013-6-19 下午01:34:27
 * @file MessageReceiver.java
 * @package com.hoo.mq.jms
 * @project ActiveMQ-5.8
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class MessageReceiver {
 
    // tcp 地址
    public static final String BROKER_URL = "tcp://mq.liuqh.com:61616?"+""
    		+ "jms.optimizeAcknowledge=true"
    		+"&jms.redeliveryPolicy.maximumRedeliveries=6"
    		+"&jms.optimizeAcknowledgeTimeOut=30000";
    // 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
    public static final String DESTINATION = "test.queue?customer.prefetchSize=2";
    
    
    public static void run() throws Exception {
        
        Connection connection = null;
        Session session = null;
        try {
            // 创建链接工厂
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createConnection();
            // 启动连接
            connection.start();
            // 创建一个session会话
            session = connection.createSession(Boolean.FALSE, Session.DUPS_OK_ACKNOWLEDGE);
            // 创建一个消息队列
            Destination destination = session.createQueue(DESTINATION);
            // 创建消息制作者
            MessageConsumer consumer = session.createConsumer(destination);
            while (true) {
                // 接收数据的时间（等待） 100 ms
                Message message = consumer.receive(1000 * 20);
                TextMessage text = (TextMessage) message;
                if (text != null) {
                    System.out.println("接收：" + text.getText());
                } else {
                    break;
                }
                if(text.getText().contains("3")){
                	throw new RuntimeException("测试异常");
                }
            }
            
            // 提交会话
            session.commit();
            
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭释放资源
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        MessageReceiver.run();
    }
}