package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-16 23:10
 */
public class Q2241 {
    int[] nums;
    long[] cnt;

    public Q2241() {
        cnt = new long[5];
        nums = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] = cnt[i] + banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        // 返回一个长度为 5 的数组，分别表示 $20 ，$50，$100 ，$200 和
        // * $500 钞票的数目，并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回 [-1]
        // * （这种情况下 不 取出任何钞票）。
        int[] res = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (amount >= nums[i] && cnt[i] > 0) {
                int num = (amount / nums[i] > cnt[i]) ? (int) cnt[i] : amount / nums[i];
                res[i] = num;
                amount = amount - nums[i] * num;
            }

        }

        if (amount == 0) {
            for (int i = 0; i < 5; i++) {
                cnt[i] -= res[i];
            }
            return res;
        }


        return new int[]{-1};
    }
}
