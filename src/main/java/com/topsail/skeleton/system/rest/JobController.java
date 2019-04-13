package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.Job;
import com.topsail.skeleton.system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system/job")
public class JobController {

    @Autowired
    JobService jobService;

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(Long id) {
        return jobService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(Job record) {
        return jobService.insert(record);
    }

    @GetMapping("/{id}")
    public Job selectByPrimaryKey(Long id) {
        return jobService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Job> selectAll() {
        return jobService.selectAll();
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(Job record) {
        return jobService.updateByPrimaryKey(record);
    }

}
