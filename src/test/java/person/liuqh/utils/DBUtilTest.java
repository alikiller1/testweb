package person.liuqh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import per.liuqh.common.utils.DBUtil;

public class DBUtilTest {
	@Test
	public void testConnect() throws Exception {
		Connection con = DBUtil.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "123");
		con.setAutoCommit(false);
		// String sql1="insert into emp (id) values(115)";
		String sql2 = "select name from emp where id=1";
		String sql3="UPDATE emp SET NAME ='cc3' WHERE id=1";
		PreparedStatement pst = con.prepareStatement(sql3);
		pst.execute();
		pst = con.prepareStatement(sql2);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		con.commit();
		DBUtil.closeCon(null, null, null, con);
	}
}
