package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.DictDetail;
import com.topsail.skeleton.system.service.DictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system/dictDetail")
public class DictDetailController {

    @Autowired
    DictDetailService dictDetailService;

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(Long id) {
        return dictDetailService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(DictDetail record) {
        return dictDetailService.insert(record);
    }

    @GetMapping("/{id}")
    public DictDetail selectByPrimaryKey(Long id) {
        return dictDetailService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<DictDetail> selectAll() {
        return dictDetailService.selectAll();
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(DictDetail record) {
        return dictDetailService.updateByPrimaryKey(record);
    }

}
