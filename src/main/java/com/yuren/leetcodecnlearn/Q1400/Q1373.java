package com.yuren.leetcodecnlearn.Q1400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-14 00:32
 */
public class Q1373 {
    int maxSum;

    public int maxSumBST(TreeNode root) {
        this.maxSum = 0;
        if (null == root) {
            return maxSum;
        }
        recursion(root);
        return maxSum;
    }

    public int[] recursion(TreeNode root) {
        int isbst = 0, sum = 0, min = 0, max = 0;
        if (root.left == null && root.right == null) {
            isbst = 1;
            min = root.val;
            max = root.val;
            sum = root.val;
        } else if (root.left != null && root.right != null) {
            int[] left = recursion(root.left);
            int[] right = recursion(root.right);
            if (right[0] == 1 && left[0] == 1 && root.val > left[3] && root.val < right[2]) {
                isbst = 1;
                min = left[2];
                max = right[3];
                sum = root.val + left[1] + right[1];
            }
        } else if (root.left != null) {
            int[] left = recursion(root.left);
            if (left[0] == 1 && left[3] < root.val) {
                isbst = 1;
                min = left[2];
                max = root.val;
                sum = root.val + left[1];
            }
        } else if (root.right != null) {
            int[] right = recursion(root.right);
            if (right[0] == 1 && right[2] > root.val) {
                isbst = 1;
                min = root.val;
                max = right[3];
                sum = root.val + right[1];
            }
        }
        if (isbst == 1) {
            this.maxSum = Math.max(this.maxSum, sum);
        }
        return new int[]{isbst, sum, min, max};
    }

    public boolean isBST(TreeNode root) {
        //中序遍历方式，保存前驱节点，如果当前节点小于前驱节点false
        TreeNode prev = null;
        if (root != null) {
            if (!isBST(root.left)) {
                return false;
            }
            if (prev != null && root.val < prev.val) {
                return false;
            }
            prev = root;
            if (!isBST(root.right)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBST(TreeNode root, int max, int min) {
        //限定了子树节点的值得范围
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isBST(root.left, min, root.val - 1) && isBST(root.right, root.val + 1, max);
    }
}
