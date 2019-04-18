package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.system.domain.DictDetail;
import com.topsail.skeleton.system.mapper.DictDetailMapper;
import com.topsail.skeleton.system.service.DictDetailService;
import com.topsail.skeleton.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven
 */
@Service
public class DictDetailServiceImpl implements DictDetailService {

    private static final String ENTITY_NAME = "dict_detail";

    @Autowired
    DictDetailMapper dictDetailMapper;

    @Override
    public IResult deleteByPrimaryKey(Long id) {
        int ret = dictDetailMapper.deleteByPrimaryKey(id);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", id);
        return Result.success();
    }

    @Override
    public IResult insert(DictDetail record) {
        int ret = dictDetailMapper.insert(record);
        ValidationUtil.isAlreadyExist(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }

    @Override
    public IResult selectByPrimaryKey(Long id) {
        DictDetail dictDetail = dictDetailMapper.selectByPrimaryKey(id);
        ValidationUtil.isNotFound(dictDetail, ENTITY_NAME, "id", id);
        return Result.success(dictDetail);
    }

    @Override
    public IResult selectAll() {
        List<DictDetail> dictDetails = dictDetailMapper.selectAll();
        return Result.success(dictDetails);
    }

    @Override
    public IResult search(Long dictId) {
        List<DictDetail> dictDetails = dictDetailMapper.search(dictId);
        return Result.success(dictDetails);
    }

    @Override
    public IResult updateByPrimaryKey(DictDetail record) {
        int ret = dictDetailMapper.updateByPrimaryKey(record);
        ValidationUtil.isNotFound(ret, ENTITY_NAME, "id", record.getId());
        return Result.success();
    }
}
