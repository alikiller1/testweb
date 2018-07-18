package per.liuqh.activemq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.management.RuntimeErrorException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
/**
 * <b>function:</b> 消息接收者； 依赖hawtbuf-1.9.jar
 * @author hoojo
 * @createDate 2013-6-19 下午01:34:27
 * @file MessageReceiver.java
 * @package com.hoo.mq.topic
 * @project ActiveMQ-5.8
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class TopicReceiver3 {
 
    // tcp 地址
    public static final String BROKER_URL = "tcp://localhost:61616";
    // 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
    public static final String TARGET = "hoo.mq.topic";
    
    
    public static void run() throws Exception {
        long startTime=System.currentTimeMillis();
        TopicConnection connection = null;
        TopicSession session = null;
        try {
            // 创建链接工厂
            TopicConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createTopicConnection();
            // 启动连接
            connection.start();
            // 创建一个session会话
            session = connection.createTopicSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
            // 创建一个消息队列
            Topic topic = session.createTopic(TARGET);
            // 创建消息订阅者
            TopicSubscriber subscriber = session.createSubscriber(topic);
         /*   Message m= subscriber.receive(1000*10);
            MapMessage map = (MapMessage) m;
            if(m!=null){
            	 System.out.println(map.getLong("time") + "接收#" + map.getString("text"));
            }*/
           
            subscriber.setMessageListener(new MessageListener() { 
                public void onMessage(Message msg) { 
                    if (msg != null) {
                        MapMessage map = (MapMessage) msg;
                        try {
                            System.out.println(map.getLong("time") + "接收#" + map.getString("text"));
                        } catch (Exception e) {
                        	System.out.println("catch exception");
                            e.printStackTrace();
                        }
                        if(1<2){
                        	throw new RuntimeException("test RuntimeException");
                        }
                    }
                } 
            }); 
            // 休眠100ms再关闭
            Thread.sleep(1000 * 20); 
            System.out.println("use time="+(System.currentTimeMillis()-startTime));
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
        TopicReceiver3.run();
    }
}