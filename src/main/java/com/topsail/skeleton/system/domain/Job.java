package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Job implements Serializable {
    private Long id;

    private String name;

    private Boolean enabled;

    private Date createTime;

    private Long sort;

    private Long deptId;

    private static final long serialVersionUID = 1L;
}