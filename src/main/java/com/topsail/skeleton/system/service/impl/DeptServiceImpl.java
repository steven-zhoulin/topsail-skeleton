package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.mapper.DeptMapper;
import com.topsail.skeleton.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper.insert(record);
    }

    @Override
    public Dept selectByPrimaryKey(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper.updateByPrimaryKey(record);
    }
}
