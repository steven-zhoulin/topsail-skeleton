package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class QuartzLog implements Serializable {
    private Long id;

    private String baenName;

    private Date createTime;

    private String cronExpression;

    private Boolean isSuccess;

    private String jobName;

    private String methodName;

    private String params;

    private Long time;

    private String exceptionDetail;

    private static final long serialVersionUID = 1L;
}