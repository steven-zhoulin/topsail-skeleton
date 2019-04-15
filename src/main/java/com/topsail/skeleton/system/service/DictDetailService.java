package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.DictDetail;

import java.util.List;

/**
 * @author Steven
 */
public interface DictDetailService {

    int deleteByPrimaryKey(Long id);

    int insert(DictDetail record);

    DictDetail selectByPrimaryKey(Long id);

    List<DictDetail> selectAll();

    List<DictDetail> search(Long dictId);

    int updateByPrimaryKey(DictDetail record);

}
