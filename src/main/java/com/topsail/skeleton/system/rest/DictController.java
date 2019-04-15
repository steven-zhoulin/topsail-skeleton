package com.topsail.skeleton.system.rest;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.system.domain.Dict;
import com.topsail.skeleton.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.NO_CONTENT) // 表示删除数据成功
    public Object deleteByPrimaryKey(@PathVariable Long id) {
        return dictService.deleteByPrimaryKey(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // 表示创建数据成功
    public Object insert(Dict record) throws AlreadyExistException {
        return dictService.insert(record);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object selectByPrimaryKey(@PathVariable Long id) {
        return dictService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Dict> selectAll() {
        return dictService.selectAll();
    }

    @GetMapping("/selectLikeName")
    @ResponseStatus(HttpStatus.OK)
    public List<Dict> selectLikeName(@RequestParam("content") String content) {
        return dictService.selectLikeName(content);
    }

    @GetMapping("/selectLikeRemark")
    @ResponseStatus(HttpStatus.OK)
    public List<Dict> selectLikeRemark(@RequestParam("content") String content) {
        return dictService.selectLikeRemark(content);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED) // 表示更新数据成功
    public Object updateByPrimaryKey(Dict record) {
        return dictService.updateByPrimaryKey(record);
    }

}
