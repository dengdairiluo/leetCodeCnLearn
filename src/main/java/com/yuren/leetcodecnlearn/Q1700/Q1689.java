package com.yuren.leetcodecnlearn.Q1700;

public class Q1689 {

    public int minPartitions(String n) {

        int res = -1;
        for (char c : n.toCharArray()) {
            int cur = (int) c - '0';
            if (cur == 9) {
                return 9;
            }
            if (cur > res) {
                res = cur;
            }
        }
        return res;
    }
}
