package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.util.TreeNode;

import java.util.List;

/**
 * @author Steven
 */
public interface DeptService {

    IResult deleteByPrimaryKey(Long id);

    IResult insert(com.topsail.skeleton.system.domain.Dept record);

    IResult selectByPrimaryKey(Long id);

    IResult selectAll();

    IResult selectLikeName(String content, boolean enabled);

    IResult updateByPrimaryKey(com.topsail.skeleton.system.domain.Dept record);

    List<TreeNode> getDeptTree(boolean isOpen);

    //Object buildTree(List<Dept> deptDTOS);
}
