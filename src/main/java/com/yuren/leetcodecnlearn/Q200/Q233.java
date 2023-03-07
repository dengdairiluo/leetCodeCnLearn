package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-23 23:26
 */
public class Q233 {

    public int countDigitOne(int n) {
        // 转换成为字符串
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int len = s.length();
        if (len == 1) {
            return n == 0 ? 0 : 1;
        }

        // 第 1 部分：求「整块」的 1 的个数
        // A[i] 表示：0~10^{i+1} - 1 里包含 1 的个数
        // i = 0 时，10^{i+1} - 1 = 10 - 1 = 9
        // i = 1 时，10^{i+1} - 1 = 100 - 1 = 99
        // 5 位数，例如 12345，讨论到 0~9999 里出现的 1 的总数就可以了
        int[] A = new int[len - 1];
        A[0] = 1;
        for (int i = 1; i < len - 1; i++) {
            A[i] = 10 * A[i - 1] + (int) Math.pow(10, i);
        }

        // 第 2 部分：求「余项」的 1 的个数
        int[] dp = new int[len];
        if (charArray[len - 1] == '0') {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            // 从右向左读每一个数位
            char currChar = charArray[len - i - 1];
            if (currChar == '0') {
                // 高位是 0，没有 1，就取决于低位中 1 的个数
                dp[i] = dp[i - 1];
            } else if (currChar == '1') {
                // 最高位是 1，高位是 1 的个数取决于后面有多少个数，要记得加 1
                int rest = Integer.parseInt(s.substring(len - i, len)) + 1;
                // dp[i - 1] 和情况 1 一样理解
                // A[i - 1] 比如 199，A[i - 1] 表示 0 到 99 的里 1 的个数
                dp[i] = rest + dp[i - 1] + A[i - 1];
            } else {
                // 最高位是 2、3、4、5、6、7、8、9、10
                // (currChar - '0') * A[i - 1] 表示有几个整块
                // dp[i - 1] 表示余数部分
                // (int) Math.pow(10, i) 最高位是 1 每一位都是 1 所以是 10 的方幂
                dp[i] = (currChar - '0') * A[i - 1] + dp[i - 1] + (int) Math.pow(10, i);
            }
        }
        return dp[len - 1];
    }
}
