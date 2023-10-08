package com.yuren.leetcodecnlearn.Q1900;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-08 23:50
 */
public class Q1973 {
    int count = 0;

    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return count;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftNum = dfs(root.left);
        int rightNum = dfs(root.right);

        if (root.val == leftNum + rightNum) {
            count++;
        }

        return root.val + leftNum + rightNum;
    }

}
