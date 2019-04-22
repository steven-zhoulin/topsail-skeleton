package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.po.User;

import java.util.List;

/**
 * @author Steven
 */
public interface UserService {

    List<User> selectAll();

    User selectByPrimaryKey(Long id);

    int insert(User user);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(User user);

}
