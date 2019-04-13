package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class VerificationCode implements Serializable {
    private Long id;

    private String code;

    private Date createTime;

    private Boolean status;

    private String type;

    private String value;

    private String scenes;

    private static final long serialVersionUID = 1L;
}