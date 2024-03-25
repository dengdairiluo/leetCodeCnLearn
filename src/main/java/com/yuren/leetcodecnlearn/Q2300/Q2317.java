package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-25 22:42
 */
public class Q2317 {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) ans |= num;
        return ans;
    }
}
