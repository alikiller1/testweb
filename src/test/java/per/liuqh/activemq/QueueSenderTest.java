package per.liuqh.activemq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;

public class QueueSenderTest extends TestBaseCase {
	@Autowired
	private QueueSender queueSender;
	@Autowired
	private QueueReceiver queueReceiver;
	
	@Test
	public void testSend() throws InterruptedException{
		queueSender.send("test.queue", "queueSender send 一条消息！");
		Thread.sleep(20000);
	}
}
