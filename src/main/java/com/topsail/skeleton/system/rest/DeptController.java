package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.po.Dept;
import com.topsail.skeleton.system.service.DeptService;
import com.topsail.skeleton.system.domain.dto.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Steven
 */
@RestController
@RequestMapping("api/system/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/tree")
    public List<TreeNode> getDeptTree(@RequestParam(value = "isOpen", defaultValue = "true") boolean isOpen) {
        List<TreeNode> tree = deptService.getDeptTree(isOpen);
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

    @GetMapping("/selectLikeName")
    @ResponseStatus(HttpStatus.OK)
    public List<TreeNode> selectLikeName(@RequestParam(value = "content", required = false) String content,
                                  @RequestParam(value = "enabled", required = false) Boolean enabled) {
        return deptService.selectLikeName(content, enabled);
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
