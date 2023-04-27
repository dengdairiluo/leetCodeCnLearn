package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-27 23:42
 */
public class Q1559 {
    int[] ints;

    public boolean containsCycle(char[][] grid) {
        ints = new int[grid.length * grid[0].length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int index = i * grid[0].length + j;
                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    int newIndex = index - grid[0].length;
                    if (!union(newIndex, index)) {
                        return true;
                    }
                }
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    int newIndex = index - 1;
                    if (!union(newIndex, index)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public int find(int index) {
        int root = ints[index];
        while (root != index) {
            index = root;
            root = ints[index];
        }
        return root;
    }

    public boolean union(int root1, int root2) {
        root1 = find(root1);
        root2 = find(root2);
        ints[root2] = root1;
        return root1 != root2;
    }

}
