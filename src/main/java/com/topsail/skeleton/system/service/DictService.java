package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Dict;

import java.util.List;

/**
 * @author Steven
 */
public interface DictService {

    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    Dict selectByPrimaryKey(Long id);

    List<Dict> selectAll();

    List<Dict> selectLikeName(String content);
    List<Dict> selectLikeRemark(String content);

    int updateByPrimaryKey(Dict record);
}
