package com.yuren.leetcodecnlearn.Q2500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-07 下午11:46
 */
public class Q2584 {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> left = new HashMap<>(); // left[p] 表示质数 p 首次出现的下标
        int[] right = new int[n]; // right[i] 表示左端点为 i 的区间的右端点的最大值

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int d = 2; d * d <= x; ++d)  // 分解质因数
                if (x % d == 0) {
                    if (left.containsKey(d))
                        right[left.get(d)] = i; // 记录左端点对应的右端点的最大值
                    else
                        left.put(d, i); // 第一次遇到质数 d
                    for (x /= d; x % d == 0; x /= d) ;
                }
            if (x > 1)
                if (left.containsKey(x))
                    right[left.get(x)] = i;
                else
                    left.put(x, i);
        }

        for (int l = 0, maxR = 0; l < n; l++) {
            if (l > maxR) // 最远可以遇到 maxR
                return maxR; // 也可以写 l-1
            maxR = Math.max(maxR, right[l]);
        }
        return -1;
    }
}
