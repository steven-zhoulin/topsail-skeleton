package com.topsail.skeleton.system.service.impl;

import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import com.topsail.skeleton.system.domain.User;
import com.topsail.skeleton.system.mapper.UserMapper;
import com.topsail.skeleton.system.service.UserService;
import com.topsail.skeleton.common.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (null == user) {
            throw new NotFoundException("user id=" + id + " not found!",
                    ErrorCode.DICT_NOT_FOUND.getCode());
        }
        return user;
    }

    @Override
    public int insert(User user) {
        int ret = userMapper.insert(user);
        if (0 == ret) {
            throw new AlreadyExistException("user id=" + user.getId() + " is exist!",
                    ErrorCode.USER_ALREADY_EXIST.getCode());
        }
        return ret;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ret = userMapper.deleteByPrimaryKey(id);
        if (0 == ret) {
            throw new NotFoundException("user id=" + id + " not found!",
                    ErrorCode.USER_NOT_FOUND.getCode());
        }
        return ret;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        int ret = userMapper.updateByPrimaryKey(user);
        if (0 == ret) {
            throw new NotFoundException("user id=" + user.getId() + " not found!",
                    ErrorCode.USER_NOT_FOUND.getCode());
        }
        return ret;
    }
}
