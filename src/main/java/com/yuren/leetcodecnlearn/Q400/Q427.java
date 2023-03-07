package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-03 23:45
 */
public class Q427 {
    public Node construct(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return constructTree(grid, 0, 0, m - 1, n - 1);
    }

    /**
     * upper x/y && down x/y, 上，左，下，右
     *
     * @param grid
     * @param ux
     * @param uy
     * @param dx
     * @param dy
     * @return
     */
    public Node constructTree(int[][] grid, int ux, int uy, int dx, int dy) {
        boolean isLeaf = true;
        for (int i = ux; i <= dx; i++) {
            for (int j = uy; j <= dy; j++) {
                if (grid[i][j] != grid[ux][uy]) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(grid[ux][uy] == 1, isLeaf);
        }
        //middle x/y
        int mx = ux + dx >> 1, my = uy + dy >> 1;
        Node upLeft = constructTree(grid, ux, uy, mx, my);
        Node upRight = constructTree(grid, ux, my + 1, mx, dy);
        Node downLeft = constructTree(grid, mx + 1, uy, dx, my);
        Node downRight = constructTree(grid, mx + 1, my + 1, dx, dy);
        return new Node(true, isLeaf, upLeft, upRight, downLeft, downRight);
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
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
}
