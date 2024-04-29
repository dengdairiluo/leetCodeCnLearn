package com.yuren.leetcodecnlearn.Q2300;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-29 下午11:50
 */
public class Q2385 {
    public int amountOfTime(TreeNode root, int start) {

        dfs(root, start);
        return ans;
    }

    int ans = 0;

    public int dfs(TreeNode root, int start) {
        int l = 0, r = 0;

        if (null != root.left) {
            l = dfs(root.left, start);
        }
        if (null != root.right) {
            r = dfs(root.right, start);
        }

        if (l >= 0 && r >= 0) {
            //都不含感染节点
            if (root.val == start) {
                ans = Math.max(l, r);
                return -1;
            } else {
                return Math.max(l, r) + 1;
            }

        } else {
            //子树中含有感染节点start
            int levelFromStartToRootFather = l < 0 ? l : r;
            ans = Math.max(ans, Math.abs(l - r));
            return levelFromStartToRootFather - 1;
        }
    }
}
