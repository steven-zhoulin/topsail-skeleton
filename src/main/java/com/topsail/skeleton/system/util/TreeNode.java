package com.topsail.skeleton.system.util;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode {

    /**
     * ID
     */
    private Long id;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 展示文字
     */
    private String text;

    /**
     * 子节点
     */
    private List<TreeNode> children;

}
