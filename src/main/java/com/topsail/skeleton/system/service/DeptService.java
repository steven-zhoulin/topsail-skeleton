package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.util.TreeNode;

import java.util.List;

/**
 * @author Steven
 */
public interface DeptService {

    int deleteByPrimaryKey(Long id);

    int insert(Dept record);

    Dept selectByPrimaryKey(Long id);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);

    List<TreeNode> getDeptTree();
}
