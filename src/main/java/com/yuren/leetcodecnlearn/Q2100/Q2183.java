package com.yuren.leetcodecnlearn.Q2100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-18 22:16
 */
public class Q2183 {
    public long countPairs(int[] nums, int k) {
        int length = nums.length;
        int cnt = 0;
        Map<Integer, Integer> gcdCntMap = new HashMap<>();
        for (int num : nums) {
            if (num % k == 0) {
                cnt++;
            } else {
                // 最大公因数
                int gcd = gcd(k, num);
                gcdCntMap.put(gcd, gcdCntMap.getOrDefault(gcd, 0) + 1);
            }
        }
        // 本身就能整除的，配上任何不能整除的数数都能整除
        long ans = (long) cnt * (length - cnt);
        // 本身能整除的配上能整除的
        ans += (long) cnt * (cnt - 1) >> 1;
        long tmp = 0;
        for (Integer key : gcdCntMap.keySet()) {
            if (key == 1) {
                continue;
            }
            Integer count = gcdCntMap.get(key);
            for (Integer nextkey : gcdCntMap.keySet()) {
                if ((key * nextkey) % k == 0) {
                    if (key.equals(nextkey)) {
                        ans += (long) count * (count - 1) / 2;
                    } else {
                        tmp += (long) count * gcdCntMap.get(nextkey);
                    }
                }
            }
        }
        return ans + (tmp / 2);
    }

    public int gcd(int num1, int num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }
}
