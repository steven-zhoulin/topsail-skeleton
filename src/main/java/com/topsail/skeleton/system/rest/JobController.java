package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.system.domain.po.Job;
import com.topsail.skeleton.system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Steven
 */
@RestController
@RequestMapping("api/system/job")
public class JobController {

    @Autowired
    JobService jobService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IResult deleteByPrimaryKey(@PathVariable Long id) {
        return jobService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public IResult insert(Job record) {
        return jobService.insert(record);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IResult selectByPrimaryKey(@PathVariable Long id) {
        return jobService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public IResult selectAll() {
        return jobService.selectAll();
    }

    @GetMapping("/listWithDeptName")
    @ResponseStatus(HttpStatus.OK)
    public IResult selectAllWithDeptName() {
        return jobService.selectAllWithDeptName();
    }

    @GetMapping("/selectLikeName")
    @ResponseStatus(HttpStatus.OK)
    public IResult selectLikeName(@RequestParam(value = "content", required = false) String content,
                                  @RequestParam("enabled") boolean enabled) {
        return jobService.selectLikeName(content, enabled);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IResult updateByPrimaryKey(Job record) {
        return jobService.updateByPrimaryKey(record);
    }

}
