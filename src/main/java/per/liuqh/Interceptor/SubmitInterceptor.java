package per.liuqh.Interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 重得提交拦截器
 * @author liuqinghua
 *
 */
public class SubmitInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("pre----------------");
		if (handler instanceof HandlerMethod) {
			System.out.println("sessionid="+request.getSession().getId());
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			SubmitToken annotation = method.getAnnotation(SubmitToken.class);
			if (annotation != null) {
				Object o = request.getSession().getAttribute("is_running");
				System.out.println("is_running--" + o);
				if (o != null) {
					System.out.println("重复提交");
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json;charset=UTF-8");
					PrintWriter out = null;
					try {
						out = response.getWriter();
					} catch (IOException e) {
						e.printStackTrace();
					}
					out.write("重复提交");
					out.flush();
					out.close();
					return false;
				}else{
					request.getSession().setAttribute("is_running", "1");
					o = request.getSession().getAttribute("is_running");
					System.out.println("is_running-----" + o);
				}
			}
			return true;
		} else {
			return super.preHandle(request, response, handler);
		}
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post------------------");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("after----------------");
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			SubmitToken annotation = method.getAnnotation(SubmitToken.class);
			if (annotation != null) {
				request.getSession().removeAttribute("is_running");
			}
		}
		super.afterCompletion(request, response, handler, ex);
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
