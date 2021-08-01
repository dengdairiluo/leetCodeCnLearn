package com.yuren.leetcodecnlearn;

public class Q156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfs(root, root);
    }

    public TreeNode dfs(TreeNode root, TreeNode parent) {
        //退出条件，返回第一个非空左儿子节点
        if (root == null) return parent;

        //一直递归到最左儿子节点
        TreeNode res = dfs(root.left, root);

        //递归回到根节点时，把根节点的左右指针置为空
        if (root == parent) {
            root.left = null;
            root.right = null;
            return res;
        }
        //一般情况，把当前节点的右指针指向父节点，左指针指向父节点的右儿子
        root.right = parent;
        root.left = parent.right;

        //返回第一个非空左儿子节点
        return res;
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
