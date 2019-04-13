package com.topsail.skeleton.system.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TreeNode {

    private String id;
    private String pid;
    private String text;
    private String state;
    private String url;
    private Map<String, Object> attributes = new HashMap();

    private List<TreeNode> children;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
