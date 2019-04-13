package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Role;

import java.util.List;

/**
 * @author Steven
 */
public interface RoleService {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}
