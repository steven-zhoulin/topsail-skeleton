package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Permission;
import com.topsail.skeleton.system.util.TreeNode;

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
