package com.ai.demos.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

import com.ai.demos.model.User;

@RestController
public class LoginController {
	
	private Logger log = (Logger)LoggerFactory.getLogger(LoginController.class);
	
	/**
     *登录操作
     **/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        if(!userName.equals("") && password!=""){
            User user =new User();
            user.setName(userName);
            user.setPwd(password);
            request.getSession().setAttribute("user",user);
            log.debug("===========================" + user.toString());
            map.put("result","1");
        }else{
        	log.debug("===========================user is null");
            map.put("result","0");
        }
        return map;
    }
    
    @RequestMapping("/toLogin")
    public ModelAndView login(){
       log.debug("to login");
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
}
