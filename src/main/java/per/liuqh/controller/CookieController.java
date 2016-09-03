package per.liuqh.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "cookieTest")
public class CookieController {
	
	@ResponseBody
	@RequestMapping(value = "setCookie")
	public String set(HttpServletRequest req, HttpServletResponse resp) {
		Cookie c1 = new Cookie("name", "liuqh");
		c1.setPath("/");
		c1.setDomain(".liuqh.com");
		resp.addCookie(c1);
		
		//测试跨1级域名，没有成功
		Cookie c2 = new Cookie("age", "10");
		c2.setPath("/");
		c2.setDomain(".liu.com");
		
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("address", "shanghai");
		c3.setPath("/");
		resp.addCookie(c3);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "getCookie", produces = "text/html;charset=UTF-8")
	public String get(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURL());
		System.out.println(req.getRequestURI());
		Cookie[] cc = req.getCookies();
		String s="";
		if (null != cc) {
			for (Cookie c : cc) {
				s=s+c.getName() + "->" + c.getValue()+"<br/>";
			}
		}
		return s;
	}
}
