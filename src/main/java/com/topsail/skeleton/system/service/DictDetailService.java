package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.DictDetail;

import java.util.List;

public interface DictDetailService {

    int deleteByPrimaryKey(Long id);

    int insert(DictDetail record);

    DictDetail selectByPrimaryKey(Long id);

    List<DictDetail> selectAll();

    int updateByPrimaryKey(DictDetail record);

}
