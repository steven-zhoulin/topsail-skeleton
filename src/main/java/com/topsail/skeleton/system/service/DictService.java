package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Dict;

import java.util.List;

public interface DictService {

    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    Dict selectByPrimaryKey(Long id);

    List<Dict> selectAll();

    int updateByPrimaryKey(Dict record);
}
