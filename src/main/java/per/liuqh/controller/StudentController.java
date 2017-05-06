package per.liuqh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import per.liuqh.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController{
	@Autowired
	private StudentService stuService;
	
	@RequestMapping("add")
	public String add(){
		try {
			stuService.add("cccdd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

}
