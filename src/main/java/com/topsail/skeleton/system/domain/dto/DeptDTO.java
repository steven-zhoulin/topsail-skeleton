package com.topsail.skeleton.system.domain.dto;

import com.topsail.skeleton.system.domain.dto.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 部门 DTO
 *
 * @author Steven
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptDTO extends TreeNode {

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否激活
     */
    private Boolean enabled;

}
