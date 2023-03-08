package com.yuren.leetcodecnlearn.Q1100;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-13 21:54
 */
public class Q1145 {


    int total;
    int x, l, r;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        total = 0;
        l = 0;
        r = 0;
        this.x = x;
        this.f(root, 0);
        int[] sum = new int[]{l, r, total - l - r - 1};
        Arrays.sort(sum);
        return sum[2] > sum[0] + sum[1];
    }

    private void f(TreeNode root, int type) {
        if (root == null) {
            return;
        }
        total++;
        boolean b = root.val == x;
        if (type == -1) {
            l++;
        }
        if (type == 1) {
            r++;
        }
        this.f(root.left, b ? -1 : type);
        this.f(root.right, b ? 1 : type);
    }
}
