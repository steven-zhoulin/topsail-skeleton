package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.DictDetail;
import com.topsail.skeleton.system.mapper.DictDetailMapper;
import com.topsail.skeleton.system.service.DictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictDetailService")
public class DictDetailServiceImpl implements DictDetailService {

    @Autowired
    DictDetailMapper dictDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dictDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DictDetail record) {
        return dictDetailMapper.insert(record);
    }

    @Override
    public DictDetail selectByPrimaryKey(Long id) {
        return dictDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DictDetail> selectAll() {
        return dictDetailMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DictDetail record) {
        return dictDetailMapper.updateByPrimaryKey(record);
    }
}
