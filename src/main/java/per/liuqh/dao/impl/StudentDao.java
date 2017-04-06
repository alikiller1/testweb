package per.liuqh.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertStu(String name){
		String sql="insert into student (name) values(?)";
		jdbcTemplate.update(sql, name);
	}

}
