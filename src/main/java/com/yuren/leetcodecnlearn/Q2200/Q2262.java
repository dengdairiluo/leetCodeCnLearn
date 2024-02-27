package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-27 23:18
 */
public class Q2262 {
    public long appealSum(String s) {

        char[] chars = s.toCharArray();
        int n = s.length();
        // 存放当前字符上一次下标
        int[] last = new int[128];
        Arrays.fill(last, -1);
        long sum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            sum += i - last[chars[i]];
            ans += sum;
            last[chars[i]] = i;
        }
        return ans;
    }
}
