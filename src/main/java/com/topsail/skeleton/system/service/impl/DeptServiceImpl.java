package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.mapper.DeptMapper;
import com.topsail.skeleton.system.service.DeptService;
import com.topsail.skeleton.system.util.TreeNode;
import com.topsail.skeleton.system.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper.insert(record);
    }

    @Override
    public Dept selectByPrimaryKey(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TreeNode> getDeptTree() {
        List<Dept> deptList = selectAll();
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
