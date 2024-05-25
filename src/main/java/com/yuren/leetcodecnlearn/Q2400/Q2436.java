package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-25 下午11:50
 */
public class Q2436 {
    // 求最大公约数
    public int minimumSplits(int[] nums) {
        int length = nums.length;
        int ans = 1;
        int a = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            a = gcd(a, num);
            if (1 == a) {
                a = 0;
                i--;
                ans++;
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
