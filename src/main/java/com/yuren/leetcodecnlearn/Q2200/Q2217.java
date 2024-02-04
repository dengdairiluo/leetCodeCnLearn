package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-04 23:00
 */
public class Q2217 {
    // 从提交记录中粘贴的最优解
    // 思路也是找规律吧 只是最后拼接的时候 使用数学方法
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        int t = (intLength - 1) / 2, star = (int) Math.pow(10, t); // 最小值
        long[] ans = new long[n];
        int cur = 0;
        // 拼凑出的最大值
        long maxVal = 1;
        for (int i = 0; i <= intLength; i++)
            maxVal *= 10;
        maxVal--;

        for (int q : queries) {
            t = star + q - 1; // 当前给定的位置的前缀 已知了
            long num = t;
            if ((intLength & 1) == 1) // 二进制位上最后一位是1 则是奇数
                t /= 10; // 奇数去掉最后一位
            while (t != 0) { // 补数据
                num = num * 10 + t % 10;
                if (num > maxVal) {
                    num = -1;
                    break;
                }
                t /= 10;
            }
            ans[cur++] = num;
        }
        return ans;
    }


    // 找规律
    // 例如5位数 最小的为10001 依次是
    // 10101 【变最后两位数都不是正确的解】
    // 10201
    // 最大为99999
    // 对6位数 最小为 100001 依次是
    // 101 101
    // 102 201 【仅变前3位数】
    // 最大为999 999
    public long[] kthPalindrome1(int[] queries, int intLength) {
        // 计算可能的最大或者最小
        int n = queries.length;
        // 奇数偶数 都适用
        long min = (long) Math.pow(10, (intLength - 2 + 1) / 2);
        long max = (long) Math.pow(10, (intLength + 1) / 2) - 1;
        // 根据给定的数组 求每个位置的 回文串
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            int q = queries[i]; // 当前位数
            // 如果超过所有可能的个数 那么不存在
            if ((long) q > (long) 9 * min) {
                res[i] = -1;
                continue; // 当前i 计算完毕
            }
            long cur = min + (q - 1); // 第一个就是 min
            String str = String.valueOf(cur);
            StringBuilder sb = new StringBuilder(str);
            // 根据奇数 或者 偶数 区分后边补什么
            if (intLength % 2 == 0) { // 偶数 补3位数
                str += sb.reverse();
            } else {
                str += sb.reverse().substring(1);
            }
            res[i] = Long.parseLong(str);
        }
        return res;
    }
}
