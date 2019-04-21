package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.mapper.DeptMapper;
import com.topsail.skeleton.system.service.DeptService;
import com.topsail.skeleton.system.service.dto.DeptDTO;
import com.topsail.skeleton.system.util.TreeBuilder;
import com.topsail.skeleton.system.util.TreeNode;
import com.topsail.skeleton.util.ValidationUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
        com.topsail.skeleton.system.domain.Dept dept = deptMapper.selectByPrimaryKey(id);
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
    public IResult updateByPrimaryKey(com.topsail.skeleton.system.domain.Dept record) {
        int ret = deptMapper.updateByPrimaryKey(record);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }

    @Override
    public List<TreeNode> selectLikeName(String content, Boolean enabled) {
        List<Dept> deptList = deptMapper.selectLikeName(content, enabled);
        List<DeptDTO> nodeList = transform(deptList);
        List<TreeNode> tree = TreeBuilder.buildByRecursive(nodeList, true);
        return tree;
    }

    @Override
    public List<TreeNode> getDeptTree(boolean isOpen) {
        List<Dept> deptList = deptMapper.selectAll();
        List<DeptDTO> nodeList = transform(deptList);
        List<TreeNode> tree = TreeBuilder.buildByRecursive(nodeList, isOpen);
        return tree;
    }

    private List<DeptDTO> transform(List<Dept> deptList) {
        List<DeptDTO> nodeList = new ArrayList<>();

        for (Dept dept : deptList) {
            DeptDTO dto = new DeptDTO();

            BeanUtils.copyProperties(dept, dto);
            dto.setText(dept.getName());

            nodeList.add(dto);
        }

        return nodeList;
    }

}
