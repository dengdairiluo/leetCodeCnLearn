package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-17 下午11:50
 */
public class Q2483 {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        int n = customers.length();
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }
        int bestTime = 0;
        int minPenalty = penalty;
        for (int i = 1; i <= n; i++) {
            char prev = customers.charAt(i - 1);
            if (prev == 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < minPenalty) {
                bestTime = i;
                minPenalty = penalty;
            }
        }
        return bestTime;
    }
}
