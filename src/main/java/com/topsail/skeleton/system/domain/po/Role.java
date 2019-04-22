package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Role implements Serializable {
    private Long id;

    private Date createTime;

    private String name;

    private String remark;

    private String dataScope;

    private static final long serialVersionUID = 1L;
}