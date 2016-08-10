package per.liuqh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
  
public class ClientThread implements Runnable {  
  
    private Socket socket;  
    BufferedReader bufferedReader = null;  
      
    public ClientThread(Socket socket) throws IOException{  
        this.socket = socket;  
        bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));  
    }  
      
    @Override  
    public void run() {  
        String conString = null;  
        try {  
            while ((conString = bufferedReader.readLine()) != null) {  
                System.out.println("来自服务器的广播："+conString);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  