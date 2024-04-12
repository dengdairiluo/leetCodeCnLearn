package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-08 下午11:52
 */
public class Q2345 {
    public int visibleMountains(int[][] peaks) {
        int n = peaks.length;
        List<int[]> arr = new ArrayList<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        // 计算所有的区间，同时统计最左边界和最右边界
        for (int[] peak : peaks) {
            arr.add(new int[]{peak[0] - peak[1], peak[0] + peak[1]});
            left = Math.min(left, peak[0] - peak[1]);
            right = Math.max(right, peak[0] + peak[1]);
        }
        // 优先按照左端点递增，如果相同则按照区间长度递减排序
        arr.sort((x, y) -> x[0] != y[0] ? (x[0] - y[0]) : ((y[1] - y[0]) - (x[1] - x[0])));
        int count = 0;
        int current = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 如果右边界已经被覆盖，直接跳过（左边界本身是递增的，所以该区间一定已经被覆盖了）
            if (arr.get(i)[1] <= current)
                continue;
            // 更新覆盖的右边界
            current = Math.max(arr.get(i)[1], current);
            count++;
            // 如果当前区间存在完全相同的重叠区间，不算一个可见的区间
            if (i < n - 1 && arr.get(i)[0] == arr.get(i + 1)[0] && arr.get(i)[1] == arr.get(i + 1)[1])
                count--;
            if (current >= right)
                break;
        }
        return count;
    }
}
