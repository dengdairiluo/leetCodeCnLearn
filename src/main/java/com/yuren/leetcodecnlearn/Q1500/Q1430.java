package com.yuren.leetcodecnlearn.Q1500;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-05 22:36
 */
public class Q1430 {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    /**
     * 辅助函数，前序遍历dfs
     *
     * @param root
     * @param arr
     * @param index
     * @return
     */
    public boolean isValid(TreeNode root, int[] arr, int index) {
        //节点空或数组匹配完成但节点非空，匹配失败
        if (root == null || index == arr.length) {
            return false;
        }
        //节点值和数组值不同，匹配失败
        if (root.val != arr[index]) {
            return false;
        }
        //当前是叶子节点，并且数组匹配完毕
        if (root.left == null && root.right == null && index == arr.length - 1) {
            return true;
        }
        //左右子树任意一边匹配成功即可
        return isValid(root.left, arr, index + 1) || isValid(root.right, arr, index + 1);
    }
}
