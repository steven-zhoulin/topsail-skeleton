package com.topsail.skeleton.system.service.dto;

import com.topsail.skeleton.system.util.TreeNode;
import lombok.Data;

import java.util.Date;

/**
 * @author Steven
 */
@Data
public class DeptTreeNode extends TreeNode {
    private Date createTime;
    private Boolean enabled;
}
