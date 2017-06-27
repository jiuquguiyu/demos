package com.ai.demos.dao.learn;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ai.demos.model.learn.LearnResource;

@Mapper
public interface LearnResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LearnResource record);

    int insertSelective(LearnResource record);

    LearnResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LearnResource record);

    int updateByPrimaryKey(LearnResource record);
    
    List<LearnResource> queryLearnResouceList(Map<String,Object> params);
}