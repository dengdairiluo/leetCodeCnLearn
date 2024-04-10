package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-10 下午11:24
 */
public class Q2348 {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0L;
        int c = 0;
        for (int num : nums)
            if (num != 0) c = 0;
            else ans += ++c;
        return ans;
    }
}
