package com.yuren.leetcodecnlearn.Q500;

public class Q564 {

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        // 不到10与10的倍数的情况
        if (num < 10 || num == Math.pow(10, len - 1)) {
            return (String.valueOf(num - 1));
        }
        // 10...01 的情况
        if ((num - 1) == Math.pow(10, len - 1)) {
            return (String.valueOf(num - 2));
        }
        // 99...99 的情况
        if ((num + 1) == Math.pow(10, len)) {
            return (String.valueOf(num + 2));
        }

        // 前半段
        int half = 0;
        for (int i = 0; i < (len + 1) / 2; i++) {
            half = half * 10 + n.charAt(i) - '0';
        }

        // 分为3种情况，对最中间一位进行一个±1
        long cand1 = half;
        long cand2 = half + 1;
        long cand3 = half - 1;
        // 记录最终的三种结果
        long res1 = cand1;
        long res2 = cand2;
        long res3 = cand3;

        // 奇偶数位结果不一样，奇数位反过来之后会少一位，比如12345，只要12
        long i = (len + 1) / 2;
        if (len % 2 == 1) {
            cand1 /= 10;
            cand2 /= 10;
            cand3 /= 10;
            i = (len - 1) / 2;
        }

        // 把后面几位加到res结尾
        for (; i > 0; i--) {
            res1 = (res1 * 10 + cand1 % 10);
            cand1 /= 10;
            res2 = (res2 * 10 + cand2 % 10);
            cand2 /= 10;
            res3 = (res3 * 10 + cand3 % 10);
            cand3 /= 10;
        }

        // 不能为本身，选出差距最小的那一个
        if (res1 - num == 0) {
            if (res2 - num < num - res3) {
                return (String.valueOf(res2));
            } else {
                return (String.valueOf(res3));
            }
        } else if (res1 > num) {
            if (res1 - num < num - res3) {
                return (String.valueOf(res1));
            } else {
                return (String.valueOf(res3));
            }
        } else {
            if (res2 - num < num - res1) {
                return (String.valueOf(res2));
            } else {
                return (String.valueOf(res1));
            }
        }
    }
}
