package com.yuren.leetcodecnlearn;

import com.yuren.leetcodecnlearn.entity.TreeNode;

public class J54 {
    /**
     * 形参k不能随着dfs的迭代而不断变化，为了记录迭代进程和结果，引入类变量count和res。
     */
    int res = 0;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        //利用形参值k对类变量count进行初始化
        this.count = k;
        //这里不要引入形参k，dfs中直接使用的是初始值为k的类变量count
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        //当root为空或者已经找到了res时，直接返回
        if (root == null || count == 0) {
            return;
        }
        dfs(root.right);
        //先--，再判断
        if (--count == 0) {
            res = root.val;
            //这里的return可以避免之后的无效迭代dfs(root.left);
            return;
        }
        dfs(root.left);
    }


}
