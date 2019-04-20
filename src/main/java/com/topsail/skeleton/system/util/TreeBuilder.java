package com.topsail.skeleton.system.util;

import java.util.ArrayList;
import java.util.List;

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
    public final static List<TreeNode> buildByRecursive(List nodes) {
        List<TreeNode> tree = new ArrayList<>();
        for (Object o : nodes) {
            TreeNode node = (TreeNode) o;
            if (0L == node.getPid()) {
                List<TreeNode> children = findChildren(node.getId(), nodes);
                node.setChildren(children);
                tree.add(node);
            }
        }

        return tree;
    }

    /**
     * 递归获取子节点下的子节点
     *
     * @param pid       父节点的ID
     * @param nodes 所有菜单树集合
     * @return
     */
    private final static List<TreeNode> findChildren(Long pid, List nodes) {

        List<TreeNode> tree = new ArrayList<>();

        for (Object o : nodes) {
            TreeNode node = (TreeNode) o;
            if (0L == node.getPid()) {
                continue;
            }

            if (node.getPid().equals(pid)) {
                List<TreeNode> children = findChildren(node.getId(), nodes);
                node.setChildren(children);
                tree.add(node);
            }
        }

        return tree;
    }

}
