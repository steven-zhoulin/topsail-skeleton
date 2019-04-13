package com.topsail.skeleton.system.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Dict implements Serializable {
    private Long id;

    private String name;

    private String remark;

    private static final long serialVersionUID = 1L;
}