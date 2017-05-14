package per.liuqh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {
	@Value("${aa}")
	private String aa;

	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "setSession", produces = "text/html;charset=UTF-8")
	public String setSession(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("sessionid="+req.getSession().getId());
		Cookie c1 = new Cookie("name", "liuqh");
		c1.setPath("/");
		c1.setDomain(".liuqh.com");
		resp.addCookie(c1);
		req.getSession().setAttribute("name","liuqh");
		return "name="+req.getSession().getAttribute("name");
	}
	
	@RequestMapping(value = "getSession", produces = "text/html;charset=UTF-8")
	public String getSession(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("sessionid="+req.getSession().getId());
		log.info("--------------->"+aa);
		return "name="+req.getSession().getAttribute("name");
	}
	
	@RequestMapping(value = "invalidate", produces = "text/html;charset=UTF-8")
	public String invalidate(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		return "";
	}
	
	@RequestMapping(value = "getName")
	public List<String> getName(HttpServletRequest req, HttpServletResponse resp){
		List<String> ret=new ArrayList<String>();
		ret.add("liu");
		ret.add("中国");
		return ret;
		
	}
}
