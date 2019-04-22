package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Permission implements Serializable {
    private Long id;

    private String alias;

    private Date createTime;

    private String name;

    private Long pid;

    private static final long serialVersionUID = 1L;
}