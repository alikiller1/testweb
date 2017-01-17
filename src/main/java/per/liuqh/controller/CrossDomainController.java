package per.liuqh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CrossDomainController {

	
	@RequestMapping(value = "/crossDomain")
	@ResponseBody
	public String test2(HttpServletRequest req) {
		String callback = req.getParameter("callback");
		String resp=callback + "([{name:'jsonp',age:'30'},{name:'jack',age:'90'}])";
		return resp;
	}

}
