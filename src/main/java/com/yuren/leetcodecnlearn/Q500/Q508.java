package com.yuren.leetcodecnlearn.Q500;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q508 {

    int max = 0;
    /**
     * HashMap<子树元素和, 次数>
     */
    private Map<Integer, Integer> res = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        posOrder(root);
        Set<Integer> keys = res.keySet();
        int n = 0;
        for (Integer key : keys) {
            if (res.get(key) == max) {
                n++;
            }
        }
        int[] ans = new int[n];
        n = 0;
        for (Integer key : keys) {
            if (res.get(key) == max) {
                ans[n++] = key;
            }
        }

        return ans;

    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    int posOrder(TreeNode root) {
        if (root == null) return 0;
        int left = posOrder(root.left);
        int right = posOrder(root.right);
        int sum = root.val + left + right;
        res.put(sum, res.getOrDefault(sum, 0) + 1);
        max = Math.max(max, res.get(sum));
        return sum;
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
