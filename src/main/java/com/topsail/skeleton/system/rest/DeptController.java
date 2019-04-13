package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.domain.User;
import com.topsail.skeleton.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

    @GetMapping("/list")
    public List<Dept> selectAll() {
        return deptService.selectAll();
    }

    @GetMapping("/{id}")
    public Dept selectByPrimaryKey(Long id) {
        return deptService.selectByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(Dept dept) {
        return deptService.insert(dept);
    }

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(Long id) {
        return deptService.deleteByPrimaryKey(id);
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(Dept dept) {
        return deptService.updateByPrimaryKey(dept);
    }

}
