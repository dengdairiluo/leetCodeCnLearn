package com.yuren.leetcodecnlearn.Q2600;

import com.yuren.leetcodecnlearn.entity.RopeTreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-28 22:58
 */
public class Q2689 {
    public char getKthCharacter(RopeTreeNode root, int k) {
        RopeTreeNode node = root;
        while (node.len > 0) {
            RopeTreeNode left = node.left, right = node.right;
            int leftLen = left != null ? Math.max(left.len, left.val.length()) : 0;
            if (k <= leftLen) {
                node = left;
            } else {
                node = right;
                k -= leftLen;
            }
        }
        return node.val.charAt(k - 1);
    }
}
