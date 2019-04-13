package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.Dict;
import com.topsail.skeleton.system.mapper.DictMapper;
import com.topsail.skeleton.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictMapper dictMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Dict record) {
        return dictMapper.insert(record);
    }

    @Override
    public Dict selectByPrimaryKey(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dict> selectAll() {
        return dictMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Dict record) {
        return dictMapper.updateByPrimaryKey(record);
    }
}
