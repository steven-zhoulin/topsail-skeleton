package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.Job;

/**
 * @author Steven
 */
public interface JobService {

    IResult deleteByPrimaryKey(Long id);

    IResult insert(Job record);

    IResult selectByPrimaryKey(Long id);

    IResult selectAll();

    IResult selectAllWithDeptName();

    IResult selectLikeName(String content, boolean enabled);

    IResult updateByPrimaryKey(Job record);
}
