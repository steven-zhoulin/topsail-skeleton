package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.RestResult;
import com.topsail.skeleton.system.domain.DictDetail;
import com.topsail.skeleton.system.service.DictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Steven
 */
@RestController
@RequestMapping("api/system/dictDetail")
public class DictDetailController {

    @Autowired
    DictDetailService dictDetailService;

    @DeleteMapping("/{id}")
    public RestResult deleteByPrimaryKey(@PathVariable Long id) {
        RestResult restResult = new RestResult();
        int ret = dictDetailService.deleteByPrimaryKey(id);
        if (1 != ret) {
            restResult.setSuccess(false);
            restResult.setMessage("删除失败!");
        }
        return restResult;
    }

    @PostMapping("")
    public RestResult insert(DictDetail record) {
        RestResult restResult = new RestResult();
        int ret = dictDetailService.insert(record);
        if (1 != ret) {
            restResult.setSuccess(false);
            restResult.setMessage("新增失败!");
        }
        return restResult;
    }

    @GetMapping("/{id}")
    public DictDetail selectByPrimaryKey(@PathVariable Long id) {
        return dictDetailService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<DictDetail> selectAll() {
        return dictDetailService.selectAll();
    }

    @GetMapping("/search")
    public List<DictDetail> search(@RequestParam("dictId") Long dictId) {
        return dictDetailService.search(dictId);
    }

    @PutMapping("/{id}")
    public RestResult updateByPrimaryKey(DictDetail record) {

        RestResult restResult = new RestResult();
        int ret = dictDetailService.updateByPrimaryKey(record);
        if (1 != ret) {
            restResult.setSuccess(false);
            restResult.setMessage("修改失败!");
        }
        return restResult;
    }

}
