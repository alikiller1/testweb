package per.liuqh.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {

	public static ArrayList<Socket> socketList = new ArrayList<Socket>();

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			System.out.println("服务端起动，等待客户端的访问... ...");
			serverSocket = new ServerSocket(30000);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "连接成功！");
				PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println("客户端"+socket.getInetAddress()+"连接成功!");  
				socketList.add(socket);
				new Thread(new ServerThread(socket)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
