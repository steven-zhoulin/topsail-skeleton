package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.DictDetail;
import com.topsail.skeleton.system.mapper.DictDetailMapper;
import com.topsail.skeleton.system.service.DictDetailService;
import com.topsail.skeleton.common.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictDetailServiceImpl implements DictDetailService {

    @Autowired
    DictDetailMapper dictDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ret = dictDetailMapper.deleteByPrimaryKey(id);
        if (0 == ret) {
            throw new NotFoundException(
                    "dict_detail id:" + id + " not found!",
                    ErrorCode.DICT_DETAIL_NOT_FOUND.getCode());
        }
        return ret;
    }

    @Override
    public int insert(DictDetail record) {
        int ret = dictDetailMapper.insert(record);
        if (0 == ret) {
            throw new AlreadyExistException(
                    "dict_detail id:" + record.getId() + " already exist!",
                    ErrorCode.DICT_DETAIL_ALREADY_EXIST.getCode());
        }
        return ret;
    }

    @Override
    public DictDetail selectByPrimaryKey(Long id) {

        DictDetail dictDetail = dictDetailMapper.selectByPrimaryKey(id);
        if (null == dictDetail) {
            throw new NotFoundException(
                    "dict_detail id:" + id + " not found!",
                    ErrorCode.DICT_DETAIL_NOT_FOUND.getCode());
        }
        return dictDetail;

    }

    @Override
    public List<DictDetail> selectAll() {
        return dictDetailMapper.selectAll();
    }

    @Override
    public List<DictDetail> search(Long dictId) {
        return dictDetailMapper.search(dictId);
    }

    @Override
    public int updateByPrimaryKey(DictDetail record) {
        int ret = dictDetailMapper.updateByPrimaryKey(record);
        if (0 == ret) {
            throw new NotFoundException(
                    "dict_detail id:" + record.getId() + " not found!",
                    ErrorCode.DICT_DETAIL_NOT_FOUND.getCode());
        }

        return ret;
    }
}
