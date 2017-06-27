package com.ai.demos.manager;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	/**
	* 拦截器
	* @param registry
	*/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // addPathPatterns 用于添加拦截规则
	    // excludePathPatterns 用户排除拦截
	    registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
	    super.addInterceptors(registry);
	}
}
