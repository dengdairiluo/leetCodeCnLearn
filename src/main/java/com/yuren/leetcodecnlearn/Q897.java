package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-17 06:32
 */
public class Q897 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode cur = root, pre = null;
        TreeNode dummy = new TreeNode(0), tail = dummy;
        while (cur != null) {
            pre = cur.left;
            if (pre != null) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    cur.left = null;
                }
            }
            tail.right = cur;
            tail = cur;
            cur = cur.right;
        }
        return dummy.right;

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
