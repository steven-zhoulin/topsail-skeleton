package com.topsail.skeleton.system.domain.dto;

import com.topsail.skeleton.system.domain.dto.TreeNode;
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
public class PermissionDTO extends TreeNode {

    /**
     * 名称
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 属性集
     */
    private Map<String, Object> attributes = new HashMap();
}
