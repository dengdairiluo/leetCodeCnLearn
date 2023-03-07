package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-06 23:50
 */
public class Q558 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        //quadTree1是叶子
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            } else {
                return quadTree2;
            }
        }
        //quadTree2是叶子
        if (quadTree2.isLeaf) {
            if (quadTree2.val) return quadTree2;
            else return quadTree1;
        }
        //quadTree1,quadTree2都不是叶子,递归比较子树
        quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        //quadTree1子节点比较是否相同,是则结合
        if (quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf && quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf && quadTree1.topLeft.val == quadTree1.topRight.val && quadTree1.topRight.val == quadTree1.bottomLeft.val && quadTree1.bottomLeft.val == quadTree1.bottomRight.val) {
            quadTree1.val = quadTree1.topLeft.val;
            quadTree1.isLeaf = true;
            quadTree1.topLeft = null;
            quadTree1.topRight = null;
            quadTree1.bottomLeft = null;
            quadTree1.bottomRight = null;
        }
        return quadTree1;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;
}
