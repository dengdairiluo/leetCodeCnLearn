package com.yuren.leetcodecnlearn.Q2300;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-24 02:00
 */
public class Q2313 {
    private final int FALSE = 0;
    private final int TRUE = 1;
    private final int OR = 2;
    private final int AND = 3;
    private final int XOR = 4;
    private final int NOT = 5;

    public int minimumFlips(TreeNode root, boolean result) {
        int[] ans = getTime(root);
        return result ? ans[0] : ans[1];
    }

    private int[] getTime(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        if (root.val == TRUE || root.val == FALSE) {
            return root.val == TRUE ? new int[]{0, 1} : new int[]{1, 0};
        }
        int[] lRes = getTime(root.left);
        int[] rRes = getTime(root.right);
        switch (root.val) {
            case OR:
                return new int[]{Math.min(lRes[0], rRes[0]), lRes[1] + rRes[1]};
            case AND:
                return new int[]{lRes[0] + rRes[0], Math.min(lRes[1], rRes[1])};
            case XOR:
                return new int[]{Math.min(lRes[0] + rRes[1], lRes[1] + rRes[0]), Math.min(lRes[0] + rRes[0], lRes[1] + rRes[1])};
            case NOT:
                return new int[]{lRes[1] + rRes[1], lRes[0] + rRes[0]};
        }
        return new int[]{0, 0};
    }
}
