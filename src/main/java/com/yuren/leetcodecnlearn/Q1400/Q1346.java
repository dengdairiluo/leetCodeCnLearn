package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-06 23:46
 */
public class Q1346 {
    public boolean checkIfExist(int[] arr) {
        int[] cnt = new int[1001];
        int[] cnt2 = new int[1001];
        for (int i : arr) {
            if (i >= 0) {
                cnt[i]++;
            } else {
                cnt2[-i]++;
            }
        }
        if (cnt[0] >= 2) {
            return true;
        }
        for (int i = 1; i < 501; i++) {
            if (cnt[i] != 0 && cnt[2 * i] != 0 || cnt2[i] != 0 && cnt2[2 * i] != 0) {
                return true;
            }
        }
        return false;
    }
}
