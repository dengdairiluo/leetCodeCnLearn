package com.yuren.leetcodecnlearn.Q2400;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-06 下午11:07
 */
public class Q2558 {
    public static int MAXK = 100100;
    public static int[] maxl = new int[MAXK];
    public static int[] maxr = new int[MAXK];
    public static int[] dfn = new int[MAXK];
    public static int[] size = new int[MAXK];
    public static int[] deep = new int[MAXK];
    public static int cnt = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        cnt = 0;
        int[] ans = new int[queries.length];
        f(root, 0);
        maxr[cnt + 1] = 0;
        int max = 0;
        for (int i = 1; i <= cnt; i++) {
            max = Math.max(deep[i], max);
            maxl[i] = max;
        }
        max = 0;
        for (int i = cnt; i >= 1; i--) {
            max = Math.max(deep[i], max);
            maxr[i] = max;
        }
        for (int i = 0; i < queries.length; i++) {
            int dfn_id = dfn[queries[i]];
            int count = size[dfn_id];
            ans[i] = Math.max(maxl[dfn_id - 1], maxr[dfn_id + count]);
        }
        return ans;
    }

    public void f(TreeNode root, int h) {
        int i = ++cnt;
        dfn[root.val] = i;
        deep[i] = h;
        size[i] = 1;
        if (root.left != null) {
            f(root.left, h + 1);
            size[i] += size[dfn[root.left.val]];
        }
        if (root.right != null) {
            f(root.right, h + 1);
            size[i] += size[dfn[root.right.val]];
        }
    }
}
