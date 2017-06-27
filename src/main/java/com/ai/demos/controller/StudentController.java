package com.ai.demos.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.demos.model.learn.LearnResource;
import com.ai.demos.service.LearnService;
import com.ai.demos.service.impl.StudentService;
import com.ai.demos.utils.ServletUtil;
import com.ai.demos.utils.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

/** 教程页面
 * Created by tianhq
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn(){
    	studentService.queryStudent();
        return "learn-resource";
    }
}