package com.topsail.skeleton.system.rest;

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
    @ResponseStatus(HttpStatus.NO_CONTENT) // 表示删除数据成功
    public int deleteByPrimaryKey(@PathVariable Long id) {
        return dictDetailService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // 表示创建数据成功
    public int insert(DictDetail record) {
        return dictDetailService.insert(record);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DictDetail selectByPrimaryKey(@PathVariable Long id) {
        return dictDetailService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<DictDetail> selectAll() {
        return dictDetailService.selectAll();
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<DictDetail> search(@RequestParam("dictId") Long dictId) {
        return dictDetailService.search(dictId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED) // 表示修改数据成功
    public int updateByPrimaryKey(DictDetail record) {
        return dictDetailService.updateByPrimaryKey(record);

    }

}
