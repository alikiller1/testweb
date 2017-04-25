package per.liuqh.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBUtil {
		private static JdbcTemplate jdbcTemplate =new JdbcTemplate(getDataSource() );
		private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	    public static final String DRIVER = "com.mysql.jdbc.Driver";  
	    public static final String URL = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&amp;characterEncoding=utf-8";
	    public static final String USERNAME = "root";  
	    public static final String PASSWORD = "123";    
	    
	    /** 
	     * 连接数据 
	     */  
	    public static  Connection getConnection() {  
	    	Connection conn=threadLocal.get();
	    	if(conn==null){
	    		   try {  
	   	            Class.forName(DRIVER);  
	   	            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
	   	        	threadLocal.set(conn);
	   	        } catch (Exception e) {  
	   	            e.printStackTrace();  
	   	        }  
	    	}
	        return conn;  
	    }  
	  
	    /** 
	     * 关闭连接对象 
	     */  
	    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {  
	        try {  
	            if (rs != null) {  
	                rs.close();  
	            }  
	            if (pstmt != null) {  
	                pstmt.close();  
	            }  
	            if (conn != null) {  
	                pstmt.close();  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    public static DataSource getDataSource(){
	    	DriverManagerDataSource dmd = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
	    	dmd.setDriverClassName(DRIVER);
	    	return dmd;
	    			 
	    }
	   public static void main(String[] args) throws SQLException, InterruptedException {
		   Connection conn=getConnection();
		 //  conn.setAutoCommit(false);
		   String sql="select count(1) as count from data";
		   PreparedStatement pst=conn.prepareStatement(sql);
		   ResultSet rs= pst.executeQuery();
		   if(rs.next()){
			   System.out.println(rs.getInt("count"));
		   }
		  // conn.commit();
		   pst.close();
		   conn.close();
	}
}
