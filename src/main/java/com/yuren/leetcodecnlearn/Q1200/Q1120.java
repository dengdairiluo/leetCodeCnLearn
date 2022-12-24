package com.yuren.leetcodecnlearn.Q1200;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-01 23:37
 */
public class Q1120 {
    private double res = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) {
            return arr;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //设置当前树的元素和
        arr[0] = left[0] + right[0] + root.val;
        //设置节点个数
        arr[1] = left[1] + right[1] + 1;
        //更新平均值
        res = Math.max(res, (double) arr[0] / arr[1]);
        return arr;
    }
}
