package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class EmailConfig implements Serializable {
    private Long id;

    private String fromUser;

    private String host;

    private String pass;

    private String port;

    private String user;

    private static final long serialVersionUID = 1L;
}