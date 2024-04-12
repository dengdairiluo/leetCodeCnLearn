package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-12 23:49
 */
public class Q1448 {
    int ans = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode node, int curMax) {
        if (node == null) {
            return;
        }
        if (node.val >= curMax) {
            ans++;
            curMax = node.val;
        }
        dfs(node.left, curMax);
        dfs(node.right, curMax);
    }
}
