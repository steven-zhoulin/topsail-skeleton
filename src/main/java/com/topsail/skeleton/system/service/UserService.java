package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author steven.zhou
 */
@Service
public interface UserService {

    List<User> selectAll();

    User selectByPrimaryKey(Long id);

    int insert(User user);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(User user);

}
