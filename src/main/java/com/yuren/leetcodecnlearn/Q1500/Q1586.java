package com.yuren.leetcodecnlearn.Q1500;

import com.yuren.leetcodecnlearn.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-08 00:36
 */
public class Q1586 {
    TreeNode root;
    List<Integer> list;
    int i;

    public Q1586(TreeNode root) {
        this.root = root;
        list = new ArrayList<>();
        dfs(root);
        i = -1;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean hasNext() {
        return i + 1 != list.size();
    }

    public int next() {
        return list.get(++i);
    }

    public boolean hasPrev() {
        return i > 0;
    }

    public int prev() {
        return list.get(--i);
    }
}
