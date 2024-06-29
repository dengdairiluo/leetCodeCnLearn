package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-29 下午11:39
 */
public class Q2507 {
    public int smallestValue(int n) {
        while (1 == 1) {
            if (isPrime(n)) {
                // 是素数，处理结束
                return n;
            }
            // 复制旧值
            int tmpN = n;
            // 质因数之和
            int primeSum = 0;
            while (n != 1) {
                // 枚举
                for (int j = 2; j <= n; j++) {
                    if (j == n) {
                        // 最后一次
                        n = 1;
                        primeSum += j;
                        break;
                    }
                    if (n % j == 0) {
                        n /= j;
                        primeSum += j;
                        break;
                    }
                }
            }
            // 更新n，用质因数之和代替
            n = primeSum;
            if (n == tmpN) {
                // 和上次值一样，结束处理
                return n;
            }
        }
    }

    // 判断是否素数
    private boolean isPrime(int i) {
        // 除到i的平方根
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
