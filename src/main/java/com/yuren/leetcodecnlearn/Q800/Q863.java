package com.yuren.leetcodecnlearn.Q800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-16 10:18
 */
public class Q863 {
    int k;
    Map<TreeNode, TreeNode> nodeParent = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public void dfsFindNodeParent(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                nodeParent.put(node.left, node);
            }
            if (node.right != null) {
                nodeParent.put(node.right, node);
            }
            dfsFindNodeParent(node.left);
            dfsFindNodeParent(node.right);
        }
    }

    public void dfsGetRes(TreeNode node, TreeNode prev, int curDist) {
        if (node != null) {
            if (curDist == k) {
                res.add(node.val);
                return;
            }
            if (nodeParent.containsKey(node) && nodeParent.get(node) != prev) {
                dfsGetRes(nodeParent.get(node), node, curDist + 1);
            }
            if (node.left != prev) {
                dfsGetRes(node.left, node, curDist + 1);
            }
            if (node.right != prev) {
                dfsGetRes(node.right, node, curDist + 1);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        dfsFindNodeParent(root);
        dfsGetRes(target, null, 0);
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
