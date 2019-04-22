package com.topsail.skeleton.system.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Steven
 */
@Data
public class JobDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Boolean enabled;

    private Date createTime;

    private Long sort;

    private Long deptId;

    private String deptName;

}