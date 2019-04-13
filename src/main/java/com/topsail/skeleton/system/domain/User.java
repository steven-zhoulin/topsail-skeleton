package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
    private Long id;

    private String avatar;

    private Date createTime;

    private String email;

    private Long enabled;

    private String password;

    private String username;

    private Date lastPasswordResetTime;

    private Long deptId;

    private String phone;

    private Long jobId;

    private static final long serialVersionUID = 1L;

}