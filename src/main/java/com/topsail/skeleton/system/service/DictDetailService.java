package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.po.DictDetail;

/**
 * @author Steven
 */
public interface DictDetailService {

    IResult deleteByPrimaryKey(Long id) throws NotFoundException;

    IResult insert(DictDetail record) throws AlreadyExistException;

    IResult selectByPrimaryKey(Long id) throws NotFoundException;

    IResult selectAll();

    IResult search(Long dictId);

    IResult updateByPrimaryKey(DictDetail record) throws NotFoundException;

}
