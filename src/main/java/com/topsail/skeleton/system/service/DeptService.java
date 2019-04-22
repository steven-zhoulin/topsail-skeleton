package com.topsail.skeleton.system.service;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.dto.TreeNode;
import com.topsail.skeleton.system.domain.po.Dept;

import java.util.List;

/**
 * @author Steven
 */
public interface DeptService {

    IResult deleteByPrimaryKey(Long id);

    IResult insert(Dept record);

    IResult selectByPrimaryKey(Long id);

    IResult selectAll();

    List<TreeNode> selectLikeName(String content, Boolean enabled);

    IResult updateByPrimaryKey(Dept record);

    List<TreeNode> getDeptTree(boolean isOpen);

}
