package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class DictDetail implements Serializable {
    private Long id;

    private String label;

    private String value;

    private String sort;

    private Long dictId;

    private static final long serialVersionUID = 1L;
}