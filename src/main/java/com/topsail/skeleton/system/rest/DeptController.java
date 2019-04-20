package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.service.DeptService;
import com.topsail.skeleton.system.service.dto.DeptDTO;
import com.topsail.skeleton.system.util.TreeNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven
 */
@RestController
@RequestMapping("api/system/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value = "/tree")
    public List<TreeNode> getDeptTree() {
        List<TreeNode> tree = deptService.getDeptTree();
        return tree;
    }

    @GetMapping("/list")
    public IResult selectAll() {
        return deptService.selectAll();
    }

    @GetMapping("/{id}")
    public IResult selectByPrimaryKey(@PathVariable Long id) {
        return deptService.selectByPrimaryKey(id);
    }

    @PostMapping("")
    public IResult insert(Dept dept) {
        return deptService.insert(dept);
    }

    @DeleteMapping("/{id}")
    public IResult deleteByPrimaryKey(@PathVariable Long id) {
        return deptService.deleteByPrimaryKey(id);
    }

    @PutMapping("/{id}")
    public IResult updateByPrimaryKey(Dept dept) {
        return deptService.updateByPrimaryKey(dept);
    }

}
