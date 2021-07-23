package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-23 22:32
 */
public class Q503 {
    /**
     * 记录最大深度
     */
    private int maxHeight = Integer.MIN_VALUE;
    /**
     * 记录bottom left tree value
     */
    private int res;

    public int findBottomLeftValue(TreeNode root) {
        bfs(root, 0);
        return res;
    }

    // 要遍历整棵树，所以没有返回值
    private void bfs(TreeNode root, int height) {
        // 叶子节点判断
        if (root.left == null && root.right == null) {
            if (height > maxHeight) {
                maxHeight = height;
                res = root.val;
            }
            // 这里要return
            return;
        }

        // 因为递归的出口在叶子节点，所以不能继续到空节点
        if (root.left != null) {
            bfs(root.left, height + 1);
        }

        if (root.right != null) {
            bfs(root.right, height + 1);
        }

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
