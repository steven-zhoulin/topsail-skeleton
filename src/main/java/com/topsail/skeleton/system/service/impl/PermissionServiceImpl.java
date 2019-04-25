package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.po.Permission;
import com.topsail.skeleton.system.mapper.PermissionMapper;
import com.topsail.skeleton.system.service.PermissionService;
import com.topsail.skeleton.system.domain.dto.PermissionDTO;
import com.topsail.skeleton.util.TreeBuilder;
import com.topsail.skeleton.system.domain.dto.TreeNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TreeNode> permissionTree() {
        List<Permission> permissionList = selectAll();
        List<PermissionDTO> nodeList = transform(permissionList);
        List<TreeNode> tree = TreeBuilder.buildByRecursive(nodeList, true);
        return tree;
    }

    private List<PermissionDTO> transform(List<Permission> permissionList) {
        List<PermissionDTO> nodeList = new ArrayList<>();

        for (Permission permission : permissionList) {
            PermissionDTO dto = new PermissionDTO();
            BeanUtils.copyProperties(permission, dto);

            dto.setText(permission.getAlias());

            nodeList.add(dto);
        }

        return nodeList;
    }
}
