package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Dept implements Serializable {
    private Long id;

    private String name;

    private Long pid;

    private Date createTime;

    private Boolean enabled = false;

    private static final long serialVersionUID = 1L;
}