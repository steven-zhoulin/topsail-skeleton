package com.topsail.skeleton.system.service;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.DictDetail;

import java.util.List;

/**
 * @author Steven
 */
public interface DictDetailService {

    int deleteByPrimaryKey(Long id) throws NotFoundException;

    int insert(DictDetail record) throws AlreadyExistException;

    DictDetail selectByPrimaryKey(Long id) throws NotFoundException;

    List<DictDetail> selectAll();

    List<DictDetail> search(Long dictId);

    int updateByPrimaryKey(DictDetail record) throws NotFoundException;

}
