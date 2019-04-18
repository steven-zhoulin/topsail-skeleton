package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.system.domain.Dept;
import com.topsail.skeleton.system.domain.Dict;
import com.topsail.skeleton.system.domain.Job;
import com.topsail.skeleton.system.mapper.DeptMapper;
import com.topsail.skeleton.system.mapper.JobMapper;
import com.topsail.skeleton.system.service.JobService;
import com.topsail.skeleton.system.service.dto.JobDTO;
import com.topsail.skeleton.util.ValidationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private static final String ENTITY_NAME = "job";

    @Autowired
    JobMapper jobMapper;

    @Autowired
    DeptMapper deptMapper;

    @Override
    public IResult deleteByPrimaryKey(Long id) {
        int ret = jobMapper.deleteByPrimaryKey(id);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", id);
        return Result.success();
    }

    @Override
    public IResult insert(Job record) {
        int ret = jobMapper.insert(record);
        ValidationUtil.isAlreadyExist(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }

    @Override
    public IResult selectByPrimaryKey(Long id) {
        Job job = jobMapper.selectByPrimaryKey(id);
        ValidationUtil.isNotFound(job, ENTITY_NAME, "id", id);
        return Result.success(job);
    }

    @Override
    public IResult selectAll() {
        List<Job> jobs = jobMapper.selectAll();
        ValidationUtil.isNotFound(jobs, ENTITY_NAME, "", null);
        return Result.success(jobs);
    }

    @Override
    public IResult selectAllWithDeptName() {

        List<JobDTO> jobDTOList = new ArrayList<>();

        List<Job> jobs = jobMapper.selectAll();
        for (Job job : jobs) {

            JobDTO jobDTO = new JobDTO();
            BeanUtils.copyProperties(job, jobDTO);

            Long deptId = job.getDeptId();
            Dept dept = deptMapper.selectByPrimaryKey(deptId);
            jobDTO.setDeptName(dept.getName());

            jobDTOList.add(jobDTO);
        }
        return Result.success(jobDTOList);
    }

    @Override
    public IResult selectLikeName(String content, boolean enabled) {

        List<JobDTO> jobDTOList = new ArrayList<>();
        List<Job> jobs = jobMapper.selectLikeName(content, enabled);

        for (Job job : jobs) {
            JobDTO jobDTO = new JobDTO();
            BeanUtils.copyProperties(job, jobDTO);

            Long deptId = job.getDeptId();
            Dept dept = deptMapper.selectByPrimaryKey(deptId);
            jobDTO.setDeptName(dept.getName());

            jobDTOList.add(jobDTO);
        }

        return Result.success(jobDTOList);
    }

    @Override
    public IResult updateByPrimaryKey(Job record) {
        int ret = jobMapper.updateByPrimaryKey(record);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }
}
