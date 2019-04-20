package com.topsail.skeleton.system.service.dto;

import com.topsail.skeleton.system.util.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuDTO extends TreeNode {

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Long sort;


    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否内部菜单
     */
    private Boolean iFrame;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 属性集
     */
    private Map<String, Object> attributes = new HashMap();

}
