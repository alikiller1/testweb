package per.liuqh.controller;
import java.io.FileNotFoundException;
/**
* @author :liuqinghua
* @version 创建时间：2017年12月4日 下午2:43:56
* 
*/
import java.io.IOException;  
import java.io.RandomAccessFile;  
  
import javax.servlet.ServletException;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  

@Controller
public class LoadController {  
  
    @RequestMapping("load")
    public void load(HttpServletRequest request, HttpServletResponse response) throws Exception   {  
        System.out.println(request.getContextPath());  
        String path="D:\\soft\\";
        String filename = "" ;  
        filename = path+"solr-6.3.0.tgz";  
        RandomAccessFile raFile = new RandomAccessFile(filename, "r");  
          
        String range = request.getHeader("RANGE");  
        int start=0, end=0;  
        if(null!=range && range.startsWith("bytes=")){  
            String[] values =range.split("=")[1].split("-");  
            start = Integer.parseInt(values[0]);  
            end = Integer.parseInt(values[1]);  
        }  
        int requestSize=0;  
        if(end!=0 && end > start){  
            requestSize = end - start + 1;  
            response.addHeader("content-length", ""+(requestSize));  
        } else {  
            requestSize = Integer.MAX_VALUE;  
        }  
          
        byte[] buffer = new byte[4096];           
        response.setContentType("application/x-download");        
        filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");  
        response.addHeader("Content-Disposition", "attachment;filename="+filename);  
        ServletOutputStream os = response.getOutputStream();  
        int needSize = requestSize;  
        raFile.seek(start);  
        while(needSize > 0){  
            int len = raFile.read(buffer);  
            if(needSize < buffer.length){  
                os.write(buffer,0,needSize);  
            } else {  
                os.write(buffer,0,len);  
                if(len < buffer.length){  
                    break;  
                }  
            }  
            needSize -= buffer.length;  
        }  
              
        raFile.close();  
        os.close();  
    }  
  
  
}  
