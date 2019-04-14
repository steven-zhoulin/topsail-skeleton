package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.Role;
import com.topsail.skeleton.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(@PathVariable Long id) {
        return roleService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(Role record) {
        return roleService.insert(record);
    }

    @GetMapping("/{id}")
    public Role selectByPrimaryKey(@PathVariable Long id) {
        return roleService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Role> selectAll() {
        return roleService.selectAll();
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(Role record) {
        return roleService.updateByPrimaryKey(record);
    }
}
