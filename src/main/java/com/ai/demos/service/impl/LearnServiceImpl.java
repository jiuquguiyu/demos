package com.ai.demos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.demos.dao.learn.LearnResourceMapper;
import com.ai.demos.model.learn.LearnResource;
import com.ai.demos.service.LearnService;
import com.github.pagehelper.PageHelper;

/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    LearnResourceMapper learnResourceMapper;
    @Override
    public int add(LearnResource learnResouce) {
        return this.learnResourceMapper.insert(learnResouce);
    }

    @Override
    public int update(LearnResource learnResouce) {
        return this.learnResourceMapper.updateByPrimaryKey(learnResouce);
    }

    @Override
    public int deleteByIds(String[] ids) {
    	int x = 0;
    	for(String id : ids){
    		Long lid = Long.valueOf(id);
    		x += this.learnResourceMapper.deleteByPrimaryKey(lid);
    	}
        return x;
    }

    @Override
    public LearnResource queryLearnResouceById(Long id) {
        return this.learnResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LearnResource> queryLearnResouceList(Map<String,Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return this.learnResourceMapper.queryLearnResouceList(params);
    }
    
}
