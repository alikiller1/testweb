package per.liuqh.log;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;

public class ActionLog {
	// 在类里面写方法，方法名诗可以任意的。此处我用标准的before和after来表示
	// 此处的JoinPoint类可以获取，action所有的相关配置信息和request等内置对象。
	public void before(JoinPoint joinpoint) {
		Object[] objs= joinpoint.getArgs();// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
		/*HttpServletRequest request=(HttpServletRequest) objs[0];
		String name=request.getParameter("name");*/
		System.out.println("--被拦截方法调用之前调用此方法，输出此语句");
	}

	public void after(JoinPoint joinpoint) throws Exception{
		Object[] objs= joinpoint.getArgs();// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
		/*HttpServletResponse response=(HttpServletResponse) objs[1];
		System.out.println(response.getCharacterEncoding());
		System.out.println(response.getContentType());*/
		System.out.println("--被拦截方法调用之后调用此方法，输出此语句");
	}
}
