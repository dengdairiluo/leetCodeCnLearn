package com.yuren.leetcodecnlearn.Q200;

public class Q277_2 {
    private static boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        int left = 0, right = n - 1;
        while (left != right) {
            if (knows(left, right)) left++;
            else right--;
        }
        for (int i = 0; i < n; i++) if (i != left && (knows(left, i) || !knows(i, left))) return -1;
        return left;

    }
}
