package com.ai.demos.manager;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ai.demos.model.User;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object handler, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		 HandlerMethod handlerMethod = (HandlerMethod) handler;
	        Method method = handlerMethod.getMethod();
	        long startTime = (Long) request.getAttribute("requestStartTime");
	        long endTime = System.currentTimeMillis();
	        long executeTime = endTime - startTime;
	        // 打印方法执行时间
	        if (executeTime > 1000) {
	            System.out.println("[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 执行耗时 : "
	                    + executeTime + "ms");
	        } else {
	            System.out.println("[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 执行耗时 : "
	                    + executeTime + "ms");
	        }
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		 boolean flag =true;
	        String ip = request.getRemoteAddr();
	        long startTime = System.currentTimeMillis();
	        request.setAttribute("requestStartTime", startTime);
	        HandlerMethod handlerMethod = (HandlerMethod) handler;
	        Method method = handlerMethod.getMethod();
	        System.out.println("用户:"+ip+",访问目标:"+method.getDeclaringClass().getName() + "." + method.getName());

	        User user=(User)request.getSession().getAttribute("user");
	        if(null==user){
	            response.sendRedirect("toLogin");
	            flag = false;
	        }else{
	            flag = true;
	        }
	        return flag;
	}

}
