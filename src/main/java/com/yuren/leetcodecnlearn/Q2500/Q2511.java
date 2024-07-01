package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-01 下午11:08
 */
public class Q2511 {
    public int captureForts(int[] forts) {
        int ans = 0;
        int pre = -1; // 表示不存在
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (pre >= 0 && forts[i] != forts[pre]) { // 一个是 1，另一个是 -1
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }
}
