package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-06 23:46
 */
public class Q1432 {
    public int maxDiff(int num) {
        if (num < 10) {
            return 8;
        }
        int n = num;
        // 123456
        int max = 0, min = 0, n1 = num % 10, f = 0;
        boolean same = true;
        while (n > 0) {
            int r = n % 10;
            if (r != 9) {
                max = r;
            }
            if (n > 9 && r != 0 && r != 1) {
                min = r;
            }
            if (r != n1) {
                same = false;
            }
            if (n < 10) {
                f = n;
            }
            n /= 10;
        }
        int ans = 0;
        if (same) {
            // 所有数字都改成8
            while (num > 0) {
                ans = ans * 10 + 8;
                num /= 10;
            }
            return ans;
        }
        int maxnum = 0, minnum = 0, plus = 1;
        if (f == 1) {
            // 所有min变成0是最小
            // 所有max变成9是最大
            while (num > 0) {
                int r = num % 10;
                if (r != min) {
                    minnum = plus * r + minnum;
                }
                if (r == max) {
                    maxnum += plus * 9;
                } else {
                    maxnum += plus * r;
                }
                num /= 10;
                plus *= 10;
            }
        } else {
            // 所有f变成1是最小
            // 所有max变成9是最大
            while (num > 0) {
                int r = num % 10;
                if (r == f) {
                    minnum += plus;
                } else {
                    minnum += plus * r;
                }
                if (r == max) {
                    maxnum += plus * 9;
                } else {
                    maxnum += plus * r;
                }
                num /= 10;
                plus *= 10;
            }
        }
        return maxnum - minnum;
    }

}
