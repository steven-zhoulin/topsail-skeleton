package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.po.Menu;
import com.topsail.skeleton.system.mapper.MenuMapper;
import com.topsail.skeleton.system.service.MenuService;
import com.topsail.skeleton.system.domain.dto.MenuDTO;
import com.topsail.skeleton.system.util.TreeBuilder;
import com.topsail.skeleton.system.domain.dto.TreeNode;
import org.springframework.beans.BeanUtils;
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
        List<MenuDTO> nodeList = transform(menuList);
        List<TreeNode> tree = TreeBuilder.buildByRecursive(nodeList, true);
        return tree;
    }

    private List<MenuDTO> transform(List<Menu> menuList) {
        List<MenuDTO> nodeList = new ArrayList<>();

        for (Menu menu : menuList) {
            MenuDTO dto = new MenuDTO();
            BeanUtils.copyProperties(menu, dto);

            dto.setText(menu.getName());
            dto.setUrl(menu.getPath());

            nodeList.add(dto);
        }

        return nodeList;
    }
}
