package per.liuqh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import per.liuqh.utils.StringUtils;
  
public class ServerThread implements Runnable {  
    private Socket socket = null;  
    private BufferedReader bufferedReader = null;  
      
    public ServerThread(Socket socket) throws IOException {  
        this.socket = socket;  
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
    }  
      
    @Override  
    public void run() {  
        String content = null;  
        try {  
            while((content = readFromClient()) != null){  
            	System.out.println("客户端"+socket.getInetAddress()+"说:"+content);
                for (Socket socket:MainServer.socketList) {  
                    PrintStream printStream = new PrintStream(socket.getOutputStream());
                    printStream.println("客户端"+socket.getInetAddress()+"说:"+content);  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    private String readFromClient(){  
        try {  
            return bufferedReader.readLine();  
        } catch (IOException e) {  
            MainServer.socketList.remove(socket);  
        }  
        return null;  
    }  
}   