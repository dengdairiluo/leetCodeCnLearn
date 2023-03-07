package com.yuren.leetcodecnlearn.Q500;

public class Q533 {
    private char[][] picture;
    private int n;

    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length;
        this.picture = picture;
        n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (col[i] == target) {
                int first = -1;
                int sum = 0;
                for (int h = 0; h < m; h++) {
                    if (picture[h][i] == 'B') {
                        if (row[h] != target) {
                            break;
                        }
                        if (first == -1) {
                            first = h;
                        } else if (!equals(first, h)) {
                            break;
                        }
                        sum++;
                    }
                }
                if (sum == target) {
                    res += sum;
                }
            }
        }
        return res;
    }

    public boolean equals(int a, int b) {
        for (int i = 0; i < n; i++) {
            if (picture[a][i] != picture[b][i]) {
                return false;
            }
        }
        return true;
    }
}
