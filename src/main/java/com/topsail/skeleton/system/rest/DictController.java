package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.RestResult;
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
    public RestResult deleteByPrimaryKey(@PathVariable Long id) {
        RestResult restResult = new RestResult();
        int ret = dictService.deleteByPrimaryKey(id);
        if (1 != ret) {
            restResult.setSuccess(false);
            restResult.setMessage("删除失败!");
        }
        return restResult;
    }

    @PostMapping("")
    public int insert(Dict record) {
        return dictService.insert(record);
    }

    @GetMapping("/{id}")
    public Dict selectByPrimaryKey(@PathVariable Long id) {
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
