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
	@RequestMapping(value = "setCookie", produces = "text/html;charset=UTF-8")
	public String set(HttpServletRequest req, HttpServletResponse resp) {
		Cookie c = new Cookie("name", "liuqh");
		c.setDomain("www.liuqh.com");
		resp.addCookie(c);
		
		Cookie c2 = new Cookie("age", "10");
		c2.setDomain(".liuqh.com");
		
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("address", "shanghai");
		
		resp.addCookie(c3);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "getCookie", produces = "text/html;charset=UTF-8")
	public String get(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cc = req.getCookies();
		if (null != cc) {
			for (Cookie c : cc) {
				System.out.println(c.getName() + "->" + c.getValue());
			}
		}
		return "success";
	}
}
