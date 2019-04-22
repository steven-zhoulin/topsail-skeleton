package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class RolesDepts implements Serializable {
    private Long roleId;

    private Long deptId;

    private static final long serialVersionUID = 1L;
}