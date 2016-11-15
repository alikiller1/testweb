package per.liuqh.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@ResponseBody
	@RequestMapping(value = "setSession", produces = "text/html;charset=UTF-8")
	public String setSession(HttpServletRequest req, HttpServletResponse resp) {
		Cookie c1 = new Cookie("name", "liuqh");
		c1.setPath("/");
		c1.setDomain(".liuqh.com");
		resp.addCookie(c1);
		req.getSession().setAttribute("name","liuqh");
		return "name="+req.getSession().getAttribute("name");
	}
	
	@ResponseBody
	@RequestMapping(value = "getSession", produces = "text/html;charset=UTF-8")
	public String getSession(HttpServletRequest req, HttpServletResponse resp) {
		log.info("123abc123abc");
		return "name="+req.getSession().getAttribute("name");
	}
	
}
