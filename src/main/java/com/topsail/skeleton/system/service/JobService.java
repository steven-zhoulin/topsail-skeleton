package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.po.Job;

/**
 * @author Steven
 */
public interface JobService {

    IResult deleteByPrimaryKey(Long id);

    IResult insert(Job record);

    IResult selectByPrimaryKey(Long id);

    IResult selectAll();

    IResult selectAllWithDeptName();

    IResult selectLikeName(String content, Boolean enabled);

    IResult updateByPrimaryKey(Job record);
}
