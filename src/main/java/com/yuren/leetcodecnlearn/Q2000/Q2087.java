package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-02 23:29
 */
public class Q2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        // 计算机器人到家的纵向和横向距离
        // 纵向距离
        int disX = startPos[0] - homePos[0];
        // 横向距离
        int disY = startPos[1] - homePos[1];

        int ans = 0;

        // 计算纵向距离的代价
        if (disX < 0) {
            for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
                ans += rowCosts[i];
            }
        } else {
            for (int i = startPos[0] - 1; i >= homePos[0]; i--) {
                ans += rowCosts[i];
            }
        }

        // 计算横向距离的代价
        if (disY < 0) {
            for (int j = startPos[1] + 1; j <= homePos[1]; j++) {
                ans += colCosts[j];
            }
        } else {
            for (int j = startPos[1] - 1; j >= homePos[1]; j--) {
                ans += colCosts[j];
            }
        }
        return ans;
    }
}
