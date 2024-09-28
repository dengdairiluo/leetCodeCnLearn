package com.yuren.leetcodecnlearn.entity;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-28 22:58
 */
public class RopeTreeNode {
    public int len;
    public String val;
    public RopeTreeNode left;
    public RopeTreeNode right;

    RopeTreeNode() {
    }

    RopeTreeNode(String val) {
        this.len = 0;
        this.val = val;
    }

    RopeTreeNode(int len) {
        this.len = len;
        this.val = "";
    }

    RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
        this.len = len;
        this.val = "";
        this.left = left;
        this.right = right;
    }
}
