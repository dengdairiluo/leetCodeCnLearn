package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-01 00:32
 */
public class Q1339 {
    public ArrayList<Integer> res = new ArrayList<Integer>();
    public int sum;
    public int best;

    public int maxProduct(TreeNode root) {
        preOrder(root);
        postOrder(root);
        return (int) (((long) best * (sum - best)) % 1000000007);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        preOrder(root.left);
        preOrder(root.right);
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = postOrder(root.left) + postOrder(root.right) + root.val;
        if (Math.abs(2 * cur - sum) < Math.abs(2 * best - sum)) {
            best = cur;
        }
        return cur;
    }
}
