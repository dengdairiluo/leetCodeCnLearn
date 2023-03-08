package com.yuren.leetcodecnlearn.Q1100;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-21 23:49
 */
public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        int max = -0x3f3f3f3f, depth = 1, ans = 0;
        d.addLast(root);
        while (!d.isEmpty()) {
            int sz = d.size(), cur = 0;
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (t.left != null) {
                    d.addLast(t.left);
                }
                if (t.right != null) {
                    d.addLast(t.right);
                }
                cur += t.val;
            }
            if (cur > max) {
                max = cur;
                ans = depth;
            }
            depth++;
        }
        return ans;
    }
}
