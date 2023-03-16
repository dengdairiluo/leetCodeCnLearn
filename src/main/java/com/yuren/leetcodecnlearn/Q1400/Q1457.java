package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-16 23:46
 */
public class Q1457 {
    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nums = 0;
        dfs(root, nums);
        return ans;
    }

    public void dfs(TreeNode root, int temp) {
        int n = temp ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if (n == 0 || (n & (n - 1)) == 0) {
                ++ans;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, n);
        }
        if (root.right != null) {
            dfs(root.right, n);
        }
    }
}
