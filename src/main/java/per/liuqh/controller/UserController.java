package per.liuqh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.liuqh.entity.User;
import per.liuqh.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	private int id=1;
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="add", produces = "text/html;charset=UTF-8")
	public String add(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		User u=new User();
		u.setName(name);
		try {
			userService.addUser(u);
			request.getSession().setAttribute("name", "liuqh");
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	@ResponseBody
	@RequestMapping(value="testSingleTon", produces = "text/html;charset=UTF-8")
	public String testSingleTon(HttpServletRequest request){
		//测试controller是不是在spring窗口中以单例形式存在
		id=id+1;
		System.out.println(id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "中国"+id;
	}
}
