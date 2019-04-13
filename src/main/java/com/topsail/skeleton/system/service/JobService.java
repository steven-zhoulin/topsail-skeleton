package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Job;

import java.util.List;

/**
 * @author Steven
 */
public interface JobService {

    int deleteByPrimaryKey(Long id);

    int insert(Job record);

    Job selectByPrimaryKey(Long id);

    List<Job> selectAll();

    int updateByPrimaryKey(Job record);
}
