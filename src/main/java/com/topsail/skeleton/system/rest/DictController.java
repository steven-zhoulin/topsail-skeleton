package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.RestResult;
import com.topsail.skeleton.system.domain.Dict;
import com.topsail.skeleton.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Steven
 */
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
    public RestResult insert(Dict record) {
        RestResult restResult = new RestResult();
        int ret = dictService.insert(record);
        if (1 != ret) {
            restResult.setSuccess(false);
            restResult.setMessage("新增失败!");
        }
        return restResult;
    }

    @GetMapping("/{id}")
    public Dict selectByPrimaryKey(@PathVariable Long id) {
        return dictService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Dict> selectAll() {
        return dictService.selectAll();
    }

    @GetMapping("/selectLikeName")
    public List<Dict> selectLikeName(@RequestParam("content") String content) {
        return dictService.selectLikeName(content);
    }

    @GetMapping("/selectLikeRemark")
    public List<Dict> selectLikeRemark(@RequestParam("content") String content) {
        return dictService.selectLikeRemark(content);
    }

    @PutMapping("/{id}")
    public RestResult updateByPrimaryKey(Dict record) {
        RestResult restResult = new RestResult();
        int ret = dictService.updateByPrimaryKey(record);
        if (1 != ret) {
            restResult.setSuccess(false);
            restResult.setMessage("修改失败!");
        }
        return restResult;
    }

}
