package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Picture implements Serializable {
    private Long id;

    private Date createTime;

    private String deleteUrl;

    private String filename;

    private String height;

    private String size;

    private String url;

    private String username;

    private String width;

    private static final long serialVersionUID = 1L;
}