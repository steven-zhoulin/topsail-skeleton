package com.topsail.skeleton.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Visits implements Serializable {
    private Long id;

    private Date createTime;

    private String date;

    private Long ipCounts;

    private Long pvCounts;

    private String weekDay;

    private static final long serialVersionUID = 1L;
}