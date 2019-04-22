package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.system.domain.po.Dict;
import com.topsail.skeleton.system.mapper.DictMapper;
import com.topsail.skeleton.system.service.DictService;
import com.topsail.skeleton.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    private static final String ENTITY_NAME = "dict";

    @Autowired
    DictMapper dictMapper;

    @Override
    public IResult deleteByPrimaryKey(Long id) {
        int ret = dictMapper.deleteByPrimaryKey(id);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", id);
        return Result.success();
    }

    @Override
    public IResult insert(Dict record) {
        int ret = dictMapper.insert(record);
        ValidationUtil.isAlreadyExist(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }

    @Override
    public IResult selectByPrimaryKey(Long id) {
        Dict dict = dictMapper.selectByPrimaryKey(id);
        ValidationUtil.isNotFound(dict, ENTITY_NAME, "id", id);
        return Result.success(dict);
    }

    @Override
    public IResult selectAll() {
        List<Dict> dicts = dictMapper.selectAll();
        return Result.success(dicts);
    }

    @Override
    public IResult selectLikeName(String content) {
        List<Dict> dicts = dictMapper.selectLikeName(content);
        return Result.success(dicts);
    }

    @Override
    public IResult selectLikeRemark(String content) {
        List<Dict> dict = dictMapper.selectLikeRemark(content);
        return Result.success(dict);
    }

    @Override
    public IResult updateByPrimaryKey(Dict record) {
        int ret = dictMapper.updateByPrimaryKey(record);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }
}
