package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class QiniuContent implements Serializable {
    private Long id;

    private String bucket;

    private String name;

    private String size;

    private String type;

    private Date updateTime;

    private String url;

    private static final long serialVersionUID = 1L;
}