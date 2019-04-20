package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.util.TreeNode;

import java.util.List;

/**
 * @author Steven
 */
public interface DeptService {

    IResult deleteByPrimaryKey(Long id);

    IResult insert(Dept record);

    IResult selectByPrimaryKey(Long id);

    IResult selectAll();

    IResult updateByPrimaryKey(Dept record);

    List<TreeNode> getDeptTree();
}
