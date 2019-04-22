package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class RolesMenus implements Serializable {
    private Long menuId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}