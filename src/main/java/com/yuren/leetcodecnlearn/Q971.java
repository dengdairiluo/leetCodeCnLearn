package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-31 23:43
 */
public class Q971 {
    List<Integer> ans;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        boolean ok = this.find(root, voyage, 0, voyage.length - 1);
        return ok ? ans : Collections.singletonList(-1);
    }

    private boolean find(TreeNode root, int[] voyage, int l, int r) {
        if (root == null) {
            return l > r;
        }
        if (l > r) {
            return false;
        }
        int cur = root.val;
        if (cur != voyage[l]) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return l == r && cur == voyage[l];
        }
        if (root.left == null) {
            return this.find(root.right, voyage, l + 1, r);
        } else if (root.right == null) {
            return this.find(root.left, voyage, l + 1, r);
        }
        if (r - l < 2) {
            return false;
        }
        int left = root.left.val, li = -1;
        int right = root.right.val, ri = -1;
        for (int i = l + 1; i <= r; i++) {
            int num = voyage[i];
            if (num == left) {
                li = i;
            } else if (num == right) {
                ri = i;
            }
        }
        if (li != l + 1 && ri != l + 1) {
            return false;
        }
        if (li == -1 || ri == -1) {
            return false;
        }
        if (li < ri) {
            boolean ans1 = this.find(root.left, voyage, li, ri - 1);
            boolean ans2 = this.find(root.right, voyage, ri, r);
            return ans1 && ans2;
        }
        ans.add(cur);
        boolean ans1 = this.find(root.right, voyage, ri, li - 1);
        boolean ans2 = this.find(root.left, voyage, li, r);
        return ans1 && ans2;
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
