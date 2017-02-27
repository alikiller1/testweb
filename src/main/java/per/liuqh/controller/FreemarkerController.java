package per.liuqh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {
	@RequestMapping(value = "/hello")
	public String helloFtl(Model model) {
		model.addAttribute("name", "张三");
		return "helloFtl";
	}
}
