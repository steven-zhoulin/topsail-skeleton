package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class QuartzJob implements Serializable {
    private Long id;

    private String beanName;

    private String cronExpression;

    private Boolean isPause;

    private String jobName;

    private String methodName;

    private String params;

    private String remark;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}