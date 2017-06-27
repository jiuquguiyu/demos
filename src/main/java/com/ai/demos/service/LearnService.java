package com.ai.demos.service;

import java.util.List;
import java.util.Map;

import com.ai.demos.model.learn.LearnResource;

/**
 * Created by tengj on 2017/4/7.
 */

public interface LearnService {
    int add(LearnResource learnResouce);
    int update(LearnResource learnResouce);
    int deleteByIds(String[] ids);
    LearnResource queryLearnResouceById(Long learnResouce);
    List<LearnResource> queryLearnResouceList(Map<String,Object> params);
}
