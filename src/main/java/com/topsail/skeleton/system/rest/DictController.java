package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.system.domain.Dict;
import com.topsail.skeleton.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/system/dict")
public class DictController {

    @Autowired
    DictService dictService;

    @DeleteMapping("/{id}")
    public int deleteByPrimaryKey(Long id) {
        return dictService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    public int insert(Dict record) {
        return dictService.insert(record);
    }

    @GetMapping("/{id}")
    public Dict selectByPrimaryKey(Long id) {
        return dictService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Dict> selectAll() {
        return dictService.selectAll();
    }

    @PutMapping("/{id}")
    public int updateByPrimaryKey(Dict record) {
        return dictService.updateByPrimaryKey(record);
    }

}
