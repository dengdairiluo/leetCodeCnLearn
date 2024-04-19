package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-19 下午11:09
 */
public class Q2365 {
    public long taskSchedulerII(int[] tasks, int space) {
        long ans = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int task : tasks) {
            ans++;
            if (map.containsKey(task)) {
                ans = Math.max(ans, map.get(task) + space + 1);
            }
            map.put(task, ans);
        }
        return ans;
    }
}
