package per.liuqh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clientSocket = new Socket("192.168.204.1", 30000);
		
		PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
		String line = null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while ((line = bufferedReader.readLine()) != null) {
			printStream.println(line);
		}
	}
		
}
