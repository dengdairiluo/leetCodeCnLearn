package com.yuren.leetcodecnlearn.Q2200;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-28 22:46
 */
public class Q2265 {
    int totalCount = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return totalCount;
    }

    public int[] dfs(TreeNode node) {
        int sum = node.val, count = 1;
        if (node.left != null) {
            int[] leftSumCount = dfs(node.left);
            sum += leftSumCount[0];
            count += leftSumCount[1];
        }
        if (node.right != null) {
            int[] rightSumCount = dfs(node.right);
            sum += rightSumCount[0];
            count += rightSumCount[1];
        }
        if (node.val == sum / count) {
            totalCount++;
        }
        return new int[]{sum, count};
    }
}
