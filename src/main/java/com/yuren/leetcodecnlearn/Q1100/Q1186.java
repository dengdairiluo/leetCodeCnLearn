package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-01 23:52
 */
public class Q1186 {
    public int maximumSum(int[] nums) {
        // 初始化：dp0 表示未删除，和为nums[0]。dp1表示已删除，空数组，和为0。
        // 但 rs 初始化只能为dp0，而不是`Math.max(dp0, dp1)`。因为空数组不符合题意。
        // dp1 这个状态需要留着迭代，但不能作为返回值。
        int dp0 = nums[0], dp1 = 0, rs = dp0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                dp0 = Math.max(0, dp0) + num;
                // 不能留空数组，所以不是 Math.max(0, dp1)
                dp1 = dp1 + num;
            } else {
                // 这一位删除，或以前已删除
                dp1 = Math.max(dp0, dp1 + num);
                // 这里dp0在下面，因为dp0的更新用不到dp1，不会因为刚更新的值覆盖了旧值导致错误。
                dp0 = Math.max(0, dp0) + num;
            }
            // 更新最大值
            rs = Math.max(rs, dp0);
            rs = Math.max(rs, dp1);
        }
        return rs;
    }
}
