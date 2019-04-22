package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Boolean enabled = false;

    private Date createTime;

    private Long sort;

    private Long deptId;

    private Dept dept;
}