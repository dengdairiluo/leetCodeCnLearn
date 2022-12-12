package com.yuren.leetcodecnlearn.Q600;

import java.util.ArrayList;
import java.util.List;

public class Q531 {
    public int findLonelyPixel(char[][] picture) {
        int ans = 0;
        int rowN = picture.length;
        int colN = picture[0].length;
        int[] row = new int[rowN];
        int[] col = new int[colN];
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                    list.add(new Integer[]{i, j});
                }
            }
        }
        for (Integer[] blackPoint : list) {
            int i = blackPoint[0];
            int j = blackPoint[1];
            if (row[i] == 1 && row[i] == col[j]) {
                ans++;
            }
        }
        return ans;
    }
}
