package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.mapper.DeptMapper;
import com.topsail.skeleton.system.service.DeptService;
import com.topsail.skeleton.system.util.TreeNode;
import com.topsail.skeleton.system.util.TreeUtil;
import com.topsail.skeleton.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven
 */
@Service
public class DeptServiceImpl implements DeptService {

    private static final String ENTITY_NAME = "dept";

    @Autowired
    DeptMapper deptMapper;

    @Override
    public IResult deleteByPrimaryKey(Long id) {
        int ret = deptMapper.deleteByPrimaryKey(id);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", id);
        return Result.success();
    }

    @Override
    public IResult insert(Dept record) {
        int ret = deptMapper.insert(record);
        ValidationUtil.isAlreadyExist(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }

    @Override
    public IResult selectByPrimaryKey(Long id) {
        Dept dept = deptMapper.selectByPrimaryKey(id);
        ValidationUtil.isNotFound(dept, ENTITY_NAME, "id", id);
        return Result.success(dept);
    }

    @Override
    public IResult selectAll() {
        List<Dept> depts = deptMapper.selectAll();
        ValidationUtil.isNotFound(depts, ENTITY_NAME, "", null);
        return Result.success(depts);
    }

    @Override
    public IResult updateByPrimaryKey(Dept record) {
        int ret = deptMapper.updateByPrimaryKey(record);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }

    @Override
    public List<TreeNode> getDeptTree() {
        List<Dept> deptList = deptMapper.selectAll();
        List<TreeNode> nodeList = transform(deptList);
        List<TreeNode> tree = TreeUtil.getRootNode(nodeList);
        return tree;
    }

    private List<TreeNode> transform(List<Dept> deptList) {
        List<TreeNode> nodeList = new ArrayList<>();

        for (Dept dept : deptList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(String.valueOf(dept.getId()));
            treeNode.setPid(String.valueOf(dept.getPid()));
            treeNode.setText(dept.getName());

            nodeList.add(treeNode);
        }

        return nodeList;
    }
}
