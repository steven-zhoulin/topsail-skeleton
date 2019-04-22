package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Menu implements Serializable {
    private Long id;

    private Date createTime;

    private Boolean iFrame;

    private String name;

    private String component;

    private Long pid;

    private Long sort;

    private String icon;

    private String path;

    private static final long serialVersionUID = 1L;
}