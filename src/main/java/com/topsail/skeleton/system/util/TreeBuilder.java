package com.topsail.skeleton.system.util;

import com.topsail.skeleton.system.domain.dto.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Steven
 */
public class TreeBuilder {

    /**
     * 获取父节点菜单
     *
     * @param nodes 所有树菜单集合
     * @return
     */
    public final static List<TreeNode> buildByRecursive(List nodes, boolean isOpen) {

        Map<Long, TreeNode> nodeMap = new HashMap<>();
        for (Object o : nodes) {
            TreeNode node = (TreeNode) o;
            nodeMap.put(node.getId(), node);
        }

        List<TreeNode> tree = new ArrayList<>();
        for (TreeNode node : nodeMap.values()) {

            // 所有无上级节点
            if (!nodeMap.containsKey(node.getPid())) {
                List<TreeNode> children = findChildren(node.getId(), nodeMap, isOpen);
                if (!isOpen && 0 < children.size()) {
                    node.setState("closed");
                }
                node.setChildren(children);
                tree.add(node);
            }

        }

        return tree;
    }

    /**
     * 递归获取子节点下的子节点
     *
     * @param pid
     * @param nodeMap
     * @param isOpen
     * @return
     */
    private final static List<TreeNode> findChildren(Long pid, Map<Long, TreeNode> nodeMap, boolean isOpen) {

        List<TreeNode> tree = new ArrayList<>();

        for (TreeNode node : nodeMap.values()) {

            if (node.getPid().equals(pid)) {
                List<TreeNode> children = findChildren(node.getId(), nodeMap, isOpen);
                if (!isOpen && 0 < children.size()) {
                    node.setState("closed");
                }
                node.setChildren(children);
                tree.add(node);
            }
        }

        return tree;
    }

}
