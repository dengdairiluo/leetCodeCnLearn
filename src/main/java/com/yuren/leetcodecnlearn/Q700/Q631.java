package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-06 00:03
 */
public class Q631 {
    Node[][] mtx;

    public Q631(int height, char width) {
        int w = width - 'A' + 1;
        mtx = new Node[height][w];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < w; j++) {
                mtx[i][j] = new Node();
            }
        }
    }

    public void set(int row, char column, int val) {
        int r = row - 1, c = column - 'A';
        Node n = mtx[r][c];
        n.val = val;
        n.compose.clear();
    }

    public int get(int row, char column) {
        int r = row - 1, c = column - 'A';
        return mtx[r][c].eval();
    }

    public int sum(int row, char column, String[] numbers) {
        int r = row - 1, c = column - 'A';
        List<Node> compose = new ArrayList<>();
        for (String q : numbers) {
            if (!q.contains(":")) {
                char icc = q.charAt(0);
                int ic = icc - 'A';
                int ir = Integer.parseInt(q.substring(1)) - 1;
                compose.add(mtx[ir][ic]);
            } else {
                // 左上 : 右下
                String[] arr = q.split(":");
                int leftCol = arr[0].charAt(0) - 'A';
                int leftRow = Integer.parseInt(arr[0].substring(1)) - 1;
                int rightCol = arr[1].charAt(0) - 'A';
                int rightRow = Integer.parseInt(arr[1].substring(1)) - 1;
                for (int i = leftRow; i <= rightRow; i++) {
                    compose.addAll(Arrays.asList(mtx[i]).subList(leftCol, rightCol + 1));
                }
            }
        }
        mtx[r][c].compose = compose;
        return mtx[r][c].eval();
    }

    private static class Node {
        int val = 0;
        List<Node> compose = new ArrayList<>();

        public int eval() {
            if (compose.size() == 0) {
                return val;
            }
            int result = 0;
            for (Node n : compose) {
                result += n.eval();
            }
            return result;
        }
    }
}
