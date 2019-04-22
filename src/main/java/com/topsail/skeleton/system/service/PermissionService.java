package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.po.Permission;
import com.topsail.skeleton.system.domain.dto.TreeNode;

import java.util.List;

/**
 * @author Steven
 */
public interface PermissionService {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<TreeNode> permissionTree();
}
