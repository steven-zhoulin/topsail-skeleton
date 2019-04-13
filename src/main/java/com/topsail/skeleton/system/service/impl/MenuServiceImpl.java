package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.Menu;
import com.topsail.skeleton.system.mapper.MenuMapper;
import com.topsail.skeleton.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public Menu selectByPrimaryKey(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }
}
