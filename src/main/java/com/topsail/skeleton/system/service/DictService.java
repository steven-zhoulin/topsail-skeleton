package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.Dict;

/**
 * @author Steven
 */
public interface DictService {

    IResult deleteByPrimaryKey(Long id) throws NotFoundException;

    IResult insert(Dict record) throws AlreadyExistException;

    IResult selectByPrimaryKey(Long id) throws NotFoundException;

    IResult selectAll();

    IResult selectLikeName(String content);
    IResult selectLikeRemark(String content);

    IResult updateByPrimaryKey(Dict record) throws NotFoundException;
}
