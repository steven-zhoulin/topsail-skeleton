package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class GenConfig implements Serializable {
    private Long id;

    private String author;

    private Boolean cover;

    private String moduleName;

    private String pack;

    private String path;

    private String apiPath;

    private static final long serialVersionUID = 1L;
}