package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    int deleteByPrimaryKey(Long id);

    int insert(Job record);

    Job selectByPrimaryKey(Long id);

    List<Job> selectAll();

    int updateByPrimaryKey(Job record);
}
