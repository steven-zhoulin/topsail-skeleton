package com.topsail.skeleton.system.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Steven
 */
public class TreeUtil {
    /**
     * 获取父节点菜单
     *
     * @param nodeList 所有树菜单集合
     * @return
     */
    public final static List<TreeNode> getRootNode(List<TreeNode> nodeList) {
        List<TreeNode> newTrees = new ArrayList<>();
        for (TreeNode treeNode : nodeList) {
            if (0 == Long.parseLong(treeNode.getPid())) {

                treeNode.setChildren(getChildrenNode(treeNode.getId(), nodeList));
                newTrees.add(treeNode);
            }
        }
        return newTrees;
    }

    /**
     * 递归获取子节点下的子节点
     *
     * @param pid       父节点的ID
     * @param nodeList 所有菜单树集合
     * @return
     */
    private final static List<TreeNode> getChildrenNode(String pid, List<TreeNode> nodeList) {

        List<TreeNode> newTrees = new ArrayList<>();

        for (TreeNode treeNode : nodeList) {
            if (0 == Long.parseLong(treeNode.getPid())) {
                continue;
            }

            if (treeNode.getPid().equals(pid)) {

                treeNode.setChildren(getChildrenNode(treeNode.getId(), nodeList));

                Map<String, Object> map = new HashMap<>();
                map.put("url", treeNode.getUrl());
                treeNode.setAttributes(map);

                newTrees.add(treeNode);
            }
        }

        return newTrees;
    }


}
