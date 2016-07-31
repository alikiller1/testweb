package per.liuqh.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.liuqh.service.OrderService;

@Controller
@RequestMapping(value="user")
public class UserController {
	private Logger log=Logger.getLogger(this.getClass());
	private int id=1;
	@Autowired
	@Qualifier(value="orderServiceImpl")
	private OrderService orderService;
	@RequestMapping(value="info")
	public String info(){
		orderService.create();
		System.out.println("info");
		return "user_info";
	}
	@ResponseBody
	@RequestMapping(value="add", produces = "text/html;charset=UTF-8")
	public String addh(HttpServletRequest request){
		log.info(request.getRequestURI());
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
