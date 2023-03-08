package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-10 00:01
 */
public class Q1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int removeMin = toBeRemoved[0];
        int removeMax = toBeRemoved[1];
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果移除区间最大值比当前区间最小值还小或者移除区间最小值比比当前区间最大值要大
            if (removeMax < interval[0] || removeMin >= interval[1]) {
                // 当前区间不移除
                result.add(getEveryList(interval[0], interval[1]));
            } else if (removeMin > interval[0] && removeMax >= interval[1]) {
                // 移除区间的头部在当前区间内，但是尾部在当前区间外
                result.add(getEveryList(interval[0], removeMin));
            } else if (removeMin <= interval[0] && removeMax < interval[1]) {
                // 移除区间尾部在当前区间内，但是头部在当前区间外
                result.add(getEveryList(removeMax, interval[1]));
            } else if (removeMin > interval[0]) {
                // 移除区间在当前区间内的
                result.add(getEveryList(interval[0], removeMin));
                result.add(getEveryList(removeMax, interval[1]));
            } else {
                continue;
            }
        }
        return result;
    }

    private List<Integer> getEveryList(int min, int max) {
        List<Integer> everyOne = new ArrayList<>();
        everyOne.add(min);
        everyOne.add(max);
        return everyOne;
    }

}
