package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.Dict;
import com.topsail.skeleton.system.mapper.DictMapper;
import com.topsail.skeleton.system.service.DictService;
import com.topsail.skeleton.common.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictMapper dictMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ret = dictMapper.deleteByPrimaryKey(id);
        if (0 == ret) {
            throw new NotFoundException(
                    "dict id=" + id + " not found!",
                    ErrorCode.DICT_NOT_FOUND.getCode());
        }
        return ret;
    }

    @Override
    public int insert(Dict record) {
        int ret = dictMapper.insert(record);
        if (0 == ret) {
            throw new AlreadyExistException(
                    "dict id:" + record.getId() + " already exist!",
                    ErrorCode.DICT_ALREADY_EXIST.getCode()
            );
        }
        return ret;
    }

    @Override
    public Dict selectByPrimaryKey(Long id) {
        Dict dict = dictMapper.selectByPrimaryKey(id);
        if (null == dict) {
            throw new NotFoundException(
                    "dict id:" + id + " not found!",
                    ErrorCode.DICT_NOT_FOUND.getCode()
            );
        }
        return dict;
    }

    @Override
    public List<Dict> selectAll() {
        return dictMapper.selectAll();
    }

    @Override
    public List<Dict> selectLikeName(String content) {
        return dictMapper.selectLikeName(content);
    }

    @Override
    public List<Dict> selectLikeRemark(String content) {
        return dictMapper.selectLikeRemark(content);
    }

    @Override
    public int updateByPrimaryKey(Dict record) {
        int ret = dictMapper.updateByPrimaryKey(record);
        if (0 == ret) {
            throw new NotFoundException(
                    "dict id:" + record.getId() + " not found!",
                    ErrorCode.DICT_NOT_FOUND.getCode());
        }
        return ret;
    }
}
