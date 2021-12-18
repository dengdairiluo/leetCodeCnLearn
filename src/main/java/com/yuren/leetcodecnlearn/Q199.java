package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-12 21:53
 */
public class Q199 {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每层元素的大小
            int len = queue.size();
            for (int i = 0; i < len; ++i) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);

                if (i == len - 1) ans.add(curr.val);
                // if(i == 0) ans.add(curr.val); 左视图
            }
        }

        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
