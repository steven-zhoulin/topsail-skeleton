package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.Job;
import com.topsail.skeleton.system.mapper.JobMapper;
import com.topsail.skeleton.system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return jobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Job record) {
        return jobMapper.insert(record);
    }

    @Override
    public Job selectByPrimaryKey(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Job> selectAll() {
        return jobMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Job record) {
        return jobMapper.updateByPrimaryKey(record);
    }
}
