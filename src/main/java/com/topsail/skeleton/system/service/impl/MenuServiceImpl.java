package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.Menu;
import com.topsail.skeleton.system.mapper.MenuMapper;
import com.topsail.skeleton.system.service.MenuService;
import com.topsail.skeleton.system.util.TreeNode;
import com.topsail.skeleton.system.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<TreeNode> menuTree() {
        List<Menu> menuList = selectAll();
        List<TreeNode> nodeList = transform(menuList);
        List<TreeNode> tree = TreeUtil.getRootNode(nodeList);
        return tree;
    }

    private List<TreeNode> transform(List<Menu> deptList) {
        List<TreeNode> nodeList = new ArrayList<>();

        for (Menu menu : deptList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(String.valueOf(menu.getId()));
            treeNode.setPid(String.valueOf(menu.getPid()));
            treeNode.setText(menu.getName());
            treeNode.setUrl(menu.getPath());

            nodeList.add(treeNode);
        }

        return nodeList;
    }
}
