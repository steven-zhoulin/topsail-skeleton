package com.topsail.skeleton.system.service;

import com.topsail.skeleton.system.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven
 */
@Service
public interface RoleService {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}
