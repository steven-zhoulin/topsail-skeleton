package com.topsail.skeleton.system.service;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.Dict;

import java.util.List;

/**
 * @author Steven
 */
public interface DictService {

    int deleteByPrimaryKey(Long id) throws NotFoundException;

    int insert(Dict record) throws AlreadyExistException;

    Dict selectByPrimaryKey(Long id) throws NotFoundException;

    List<Dict> selectAll();

    List<Dict> selectLikeName(String content);
    List<Dict> selectLikeRemark(String content);

    int updateByPrimaryKey(Dict record) throws NotFoundException;
}
