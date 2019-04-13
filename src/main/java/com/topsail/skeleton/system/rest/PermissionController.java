package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.Permission;
import com.topsail.skeleton.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(Long id) {
        return permissionService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(Permission record) {
        return permissionService.insert(record);
    }

    @GetMapping("/{id}")
    public Permission selectByPrimaryKey(Long id) {
        return permissionService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Permission> selectAll() {
        return permissionService.selectAll();
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(Permission record) {
        return permissionService.updateByPrimaryKey(record);
    }

}
