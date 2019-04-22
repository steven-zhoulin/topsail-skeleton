package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.po.Menu;
import com.topsail.skeleton.system.domain.dto.TreeNode;

import java.util.List;

/**
 * @author Steven
 */
public interface MenuService {

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

    List<TreeNode> menuTree();


}
