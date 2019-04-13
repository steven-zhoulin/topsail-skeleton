package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Menu;

import java.util.List;

public interface MenuService {

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);
}
