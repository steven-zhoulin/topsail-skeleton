package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Log implements Serializable {
    private Long id;

    private Date createTime;

    private String description;

    private String logType;

    private String method;

    private String requestIp;

    private Long time;

    private String username;

    private String exceptionDetail;

    private String params;

    private static final long serialVersionUID = 1L;
}