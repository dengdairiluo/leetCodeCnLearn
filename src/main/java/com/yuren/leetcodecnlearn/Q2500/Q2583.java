package com.yuren.leetcodecnlearn.Q2500;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-06 下午11:15
 */
public class Q2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> a = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            long sum = 0;
            List<TreeNode> tmp = q;
            q = new ArrayList<>();
            for (TreeNode node : tmp) {
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            a.add(sum);
        }
        int n = a.size();
        if (k > n) {
            return -1;
        }
        Collections.sort(a);
        return a.get(n - k);
    }
}
