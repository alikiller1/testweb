package per.liuqh.activemq;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
/**
 * 
 * @author LL
 *
 */
@Component
public class QueueSender {

	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;// 通过@Qualifier修饰符来注入对应的bean

	/**
	 * 发送一条消息到指定的队列（目标），只有一个消费端能收到
	 * 
	 * @param queueName
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	public void send(String queueName, final String message) {
		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage mg= session.createTextMessage(message);
				mg.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
				mg.setJMSExpiration(1000*10);
				mg.setJMSRedelivered(false);
				return mg;
			}
		});
	}
	
	/**
	 * 发送一条消息到指定的队列（目标），只有一个消费端能收到
	 * 
	 * @param queueName
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	public void send2(String queueName, final String message) {
		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage mg= session.createTextMessage(message);
				mg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				return mg;
			}
		});
	}

}
