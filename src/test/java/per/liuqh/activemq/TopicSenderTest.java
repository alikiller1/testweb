package per.liuqh.activemq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;

public class TopicSenderTest extends TestBaseCase {
	@Autowired
	private TopicSender topicSender;
	

	@Test
	public void testSend() throws InterruptedException{
		topicSender.send("test.topic", "topicSender send 一条消息！");
		Thread.sleep(20000);
	}
}
