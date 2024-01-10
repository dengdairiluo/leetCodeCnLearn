package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-10 23:21
 */
public class Q2167 {
    public int minimumTime(String s) {
        // 左侧：只用考虑两种情况，一按 2 算，二整体移除前缀，选最优。
        int n = s.length(), res = n, cnt = 0;
        for (int i = 0; i < n; ) {
            // 计算左侧
            // 先按 2 算
            cnt += (s.charAt(i) - '0') * 2;
            // 如果大于长度，则按长度计算
            if (cnt > ++i) cnt = i;
            // 左侧 + 后缀，右侧先接最大值，即后缀计算，逐步更新。
            res = Math.min(res, cnt + n - i);
        }
        return res;
    }
}
