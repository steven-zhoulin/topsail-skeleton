package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.po.Menu;
import com.topsail.skeleton.system.service.MenuService;
import com.topsail.skeleton.system.domain.dto.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(@PathVariable Long id) {
        return menuService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(Menu record) {
        return menuService.insert(record);
    }

    @GetMapping("/{id}")
    public Menu selectByPrimaryKey(@PathVariable Long id) {
        return menuService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Menu> selectAll() {
        return menuService.selectAll();
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(Menu record) {
        return menuService.updateByPrimaryKey(record);
    }

    @GetMapping(value = "/tree")
    public List<TreeNode> getDeptTree() {
        List<TreeNode> tree = menuService.menuTree();
        return tree;
    }
}
