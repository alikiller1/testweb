package per.liuqh.socket;

import java.io.IOException; 
import java.net.DatagramSocket; 
public class ChatRoomDemo { 
  /** 
   * @param args 
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException { 
    System.out.println("----进入聊天室----"); 
    DatagramSocket send = new DatagramSocket(); 
    DatagramSocket rece = new DatagramSocket(10001); 
    new Thread(new SendDemo(send)).start();// 启动发送端线程 
    new Thread(new ReceiveDemo(rece)).start();// 启动接收端线程 
  } 
}
