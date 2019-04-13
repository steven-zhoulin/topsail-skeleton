package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class QiniuConfig implements Serializable {
    private Long id;

    private String bucket;

    private String host;

    private String type;

    private String zone;

    private String accessKey;

    private String secretKey;

    private static final long serialVersionUID = 1L;
}