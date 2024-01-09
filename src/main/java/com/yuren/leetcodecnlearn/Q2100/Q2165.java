package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-09 22:22
 */
public class Q2165 {
    public long smallestNumber(long num) {
        long temp = num;
        int[] cnt = new int[10];
        num = Math.abs(num);
        while (num != 0) {
            int n = (int) (num % 10);
            cnt[n]++;
            num /= 10;
        }
        long ans = 0;
        if (temp > 0) {
            for (int i = 1; i < 10; i++) {
                if (cnt[i] != 0) {
                    ans = i;
                    cnt[i]--;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (cnt[i] > 0) {
                    ans = ans * 10 + i;
                    cnt[i]--;
                }
            }
        } else {
            for (int i = 9; i >= 0; i--) {
                while (cnt[i] > 0) {
                    ans = ans * 10 + i;
                    cnt[i]--;
                }
            }
            ans *= -1;
        }
        return ans;
    }
}
