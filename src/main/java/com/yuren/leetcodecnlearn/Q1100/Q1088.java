package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-18 23:28
 */
public class Q1088 {
    /**
     * 总体思路就是枚举可用的数字组合  以及这个组合的reverse 看是不是符合要求
     */
    int[] nums = new int[]{0, 1, 6, 8, 9};
    int[] revs = new int[]{0, 1, 9, 8, 6};

    int n;
    int cnt = 0;

    public int confusingNumber2(int n) {
        this.n = n;
        dfs(0, 0, 0);
        return cnt;
    }

    private void dfs(int curr, int rev, int digit) {
        if (curr > n) {
            // 当前枚举的数字 > n 结束
            return;
        }

        if (curr != rev) {
            cnt++; // 是易混淆数
        }
        // 枚举下一个要加上的数 比如9 假设当前curr是16
        // curr     16
        // nextCurr 16*10 + 9         =169
        // nextRev  9*100 + rev(61)   =961
        for (int k = 0; k < 5; k++) {
            if (digit == 0 && k == 0) {
                continue; // 前导0 不符合要求
            }
            // 下一个数字nextCurr是 curr*10+[] 如果当前curr>n/10 就没有继续的必要了 nextCurr一定过大 剪枝
            if (curr > n / 10) {
                return;
            }
            int nextCurr = curr * 10 + nums[k];
            int nextRev = revs[k] * (int) (Math.pow(10, digit)) + rev;
            dfs(nextCurr, nextRev, digit + 1);

        }
    }
}
