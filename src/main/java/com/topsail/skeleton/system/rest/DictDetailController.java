package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.system.domain.DictDetail;
import com.topsail.skeleton.system.service.DictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK) // 表示删除数据成功
    public IResult deleteByPrimaryKey(@PathVariable Long id) {
        IResult result = dictDetailService.deleteByPrimaryKey(id);
        System.out.println("result: " + result);
        return result;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // 表示创建数据成功
    public IResult insert(DictDetail record) {
        return dictDetailService.insert(record);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IResult selectByPrimaryKey(@PathVariable Long id) {
        return dictDetailService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public IResult selectAll() {
        return dictDetailService.selectAll();
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public IResult search(@RequestParam("dictId") Long dictId) {
        return dictDetailService.search(dictId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED) // 表示修改数据成功
    public IResult updateByPrimaryKey(DictDetail record) {
        return dictDetailService.updateByPrimaryKey(record);

    }

}
