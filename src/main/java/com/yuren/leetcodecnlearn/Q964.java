package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-27 23:37
 */
public class Q964 {
    public int leastOpsExpressTarget(int x, int target) {
        int[] nums = new int[32];
        int len = 0;
        for (; target > 0; len++) {
            nums[len] = target % x;
            target = target / x;
        }
        //表示更高一位为转换为反向表示时需要增加的运算符数目
        int lastReverse = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = len - 1; i >= 0; i--) {
            //个位时为加2
            int m = i == 0 ? 2 : i;
            //正向表示（例如3*5*5*5表示为5*5*5+5*5*5）所需要的数目
            int forward = nums[i] * m;
            //反向表示（例如3*5*5*5表示为5*5*5*5-5*5*5-5*5*5-5*5*5）,反向表示需要考虑向高位进1
            int reverse = (x - nums[i]) * m + Math.min(lastReverse - i - 1, i + 1);
            //
            ans += Math.min(forward, reverse);
            //如果当前取得就是反向表示，那么后面再考虑高一位转换成反向表示需要增加的运算为0
            lastReverse = forward >= reverse ? 0 : reverse - forward;
        }
        return ans;
    }
}
