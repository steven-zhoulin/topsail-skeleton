package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsersRoles implements Serializable {
    private Long userId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}