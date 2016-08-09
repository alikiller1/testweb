package per.liuqh.socket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class ChatUser {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InetAddress[] a = InetAddress.getAllByName("qq.com");
		System.out.println(Arrays.toString(a));

		InetAddress b = InetAddress.getByAddress(new byte[] { 14, 17, 32,
				(byte) 211 });
		System.out.println(b);
		System.out.println(InetAddress.getLocalHost() + "-->进入聊天室");
		DatagramSocket rece = new DatagramSocket(10001);
		new Thread(new ReceiveDemo(rece)).start();// 启动接收端线程

	}
}
