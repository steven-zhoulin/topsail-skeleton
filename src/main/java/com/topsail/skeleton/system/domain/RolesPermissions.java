package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class RolesPermissions implements Serializable {
    private Long roleId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;
}