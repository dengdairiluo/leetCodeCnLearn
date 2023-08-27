package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-27 23:19
 */
public class Q1887 {
    public int reductionOperations(int[] nums) {
        int[] hash = new int[50001];
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            hash[num]++;
            min = Math.min(min, num);
        }
        int ans = 0, sum = 0;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0 && i != min) {
                sum += hash[i];
                ans += sum;
            }
        }
        return ans;
    }
}
