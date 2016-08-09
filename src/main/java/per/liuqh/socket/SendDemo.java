package per.liuqh.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo implements Runnable {
	private DatagramSocket ds;

	// 有参数构造函数
	public SendDemo(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(
					System.in));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				byte[] buf = line.getBytes();
				/*
				 * //192.168.1.255是ip段广播地址，发给这个IP的信息，
				 * 在192.168.1.1-192.168.1.255的ip段的所有IP地址都能收到消息
				 */
				DatagramPacket dp = new DatagramPacket(buf, buf.length,
						InetAddress.getByName("192.168.37.255"), 10001);
				ds.send(dp);
				/*if ("886".equals(line)){
					break;
				}*/
					
			}
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}