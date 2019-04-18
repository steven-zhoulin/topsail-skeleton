package com.topsail.skeleton.system.util;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TreeNode {

    private String id;
    private String pid;
    private String text;
    private String state;
    private String url;
    private Map<String, Object> attributes = new HashMap();

    private List<TreeNode> children;

}
