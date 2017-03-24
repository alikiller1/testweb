package per.liuqh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.liuqh.dao.impl.StudentDao;


@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public void add(String name) throws Exception{
		studentDao.insertStu(name);
		//try{
		if(1<2){
			throw new Exception("ddd1233");
		}
		/*}catch(Exception e){
			System.out.println("get get get ");
			e.printStackTrace();
		}*/
	}
	
	public void dof1(String name){
		studentDao.insertStu(name);
	}


}
