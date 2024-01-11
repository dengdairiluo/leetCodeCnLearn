package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-11 22:20
 */
public class Q2168 {
    public int equalDigitFrequency(String s) {
        long base = 100007;
        char[] str = s.toCharArray();
        HashSet<Long> set = new HashSet<>();
        // cnts[3] = 10，表示3这个数字出现了10次
        int[] cnts = new int[10];

        for (int left = 0; left < str.length; left++) {
            Arrays.fill(cnts, 0);
            long hashCode = 0;
            // 用于模拟hash函数
            int curVal = 0;
            // 出现次数最多，出现了多少次
            int maxCnt = 0;
            // 出现次数最多的，有多少种字符
            int maxKinds = 0;
            // 一共有多少种不同字符
            int allKinds = 0;
            for (int right = left; right < str.length; right++) {
                curVal = str[right] - '0';
                // 模拟hash函数
                hashCode = hashCode * base + curVal + 1;
                cnts[curVal]++;
                if (cnts[curVal] == 1) {
                    allKinds++;
                }
                if (cnts[curVal] > maxCnt) {
                    maxCnt = cnts[curVal];
                    maxKinds = 1;
                } else if (cnts[curVal] == maxCnt) {
                    maxKinds++;
                }
                if (maxKinds == allKinds) {
                    set.add(hashCode);
                }
            }
        }
        return set.size();
    }
}
