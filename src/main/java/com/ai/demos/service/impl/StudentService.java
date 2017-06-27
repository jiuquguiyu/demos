package com.ai.demos.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

import com.ai.demos.controller.LoginController;
import com.ai.demos.dao.student.StudentMapper;
import com.ai.demos.model.student.Student;

@Service
public class StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	private Logger log = (Logger)LoggerFactory.getLogger(LoginController.class);
	
	public void queryStudent(){
    	Student stu = studentMapper.selectByPrimaryKey(10001L);
    	
    	log.debug("stu is a " + stu.getName());
    }
}
