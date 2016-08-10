package per.liuqh.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class HelloHandler extends TextWebSocketHandler {
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<WebSocketSession> webSocketSet = new CopyOnWriteArraySet<WebSocketSession>();

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private WebSocketSession session;

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		for(WebSocketSession item:webSocketSet){
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		this.session = session;
		webSocketSet.add(session); // 加入set中
		addOnlineCount(); // 在线数加1
		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
		// 与客户端完成连接后调用
		System.out.println("afterConnectionEstablished");
		System.out.println("getId:" + session.getId());
		System.out.println("getLocalAddress:" + session.getLocalAddress().toString());
		System.out.println("getTextMessageSizeLimit:" + session.getTextMessageSizeLimit());
		System.out.println("getUri:" + session.getUri().toString());
		System.out.println("getPrincipal:" + session.getPrincipal());
		session.sendMessage(new TextMessage("你好".getBytes()));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// 消息传输出错时调用
		System.out.println("handleTransportError");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        webSocketSet.remove(session);  //从set中删除
        subOnlineCount();           //在线数减1    
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	public static synchronized void addOnlineCount() {
		HelloHandler.onlineCount++;
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	
	 public static synchronized void subOnlineCount() {
		 HelloHandler.onlineCount--;
	    }
	 public void sendMessage(TextMessage message) throws IOException{
		 session.sendMessage(message);
	 }
}