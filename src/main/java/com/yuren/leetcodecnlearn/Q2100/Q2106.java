package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-11 22:26
 */
public class Q2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // 向左最远能到 fruits[left][0]
        int left = lowerBound(fruits, startPos - k);
        int right = left, s = 0, n = fruits.length;
        for (; right < n && fruits[right][0] <= startPos; right++)
            // 从 fruits[left][0] 到 startPos 的水果数
            s += fruits[right][1];
        int ans = s;
        for (; right < n && fruits[right][0] <= startPos + k; right++) {
            // 枚举最右位置为 fruits[right][0]
            s += fruits[right][1];
            while (fruits[right][0] * 2 - fruits[left][0] - startPos > k &&
                    fruits[right][0] - fruits[left][0] * 2 + startPos > k)
                // fruits[left][0] 无法到达
                s -= fruits[left++][1];
            // 更新答案最大值
            ans = Math.max(ans, s);
        }
        return ans;
    }

    // 见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[][] fruits, int target) {
        int left = 0;
        int right = fruits.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (fruits[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
