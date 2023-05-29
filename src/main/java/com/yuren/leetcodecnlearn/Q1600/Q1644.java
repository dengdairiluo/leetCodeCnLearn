package com.yuren.leetcodecnlearn.Q1600;

import com.yuren.leetcodecnlearn.entity.TreeNode;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-29 23:29
 */
public class Q1644 {
    //用来保存最近公共祖先
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        //后序遍历root的左右节点
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        //标识当前节点是否包含p或q
        boolean bl = false;
        //第 3 或 4 情况发生，进行记录
        if (root.val == p.val || root.val == q.val) {
            if (l || r) {
                ans = root;
            }
            bl = true;
        }
        //第2种情况发生，只在首次发生时记录
        if (l && r && ans == null) {
            ans = root;
        }
        //返回当前节点以及其子节点是否包含p或q
        return bl || l || r;
    }
}
