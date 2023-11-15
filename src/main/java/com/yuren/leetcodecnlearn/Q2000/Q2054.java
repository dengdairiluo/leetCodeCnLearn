package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-15 23:53
 */
public class Q2054 {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int n = events.length;
        int index = n - 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(events[index][0], events[index][2]);
        //返回的结果，初始值为最晚开始活动的价值
        int res = events[index][2];
        index--;
        while (index >= 0) {
            int[] arr = events[index];
            //二分查询有无在当前endTimei之后被记录的时间节点
            Integer t1 = map.higherKey(arr[1]);
            if (t1 != null) {
                //存在，价值相加与res比较
                res = Math.max(res, arr[2] + map.get(t1));
            }
            //二分查找有无在当前startTimei之后或等于startTimei且被记录的时间节点
            Integer t2 = map.ceilingKey(arr[0]);
            if (t2 != null) {
                //若存在，需要当前valuei大于被记录的valuei值时才会添加新的时间节点记录
                if (arr[2] > map.get(t2)) {
                    map.put(arr[0], arr[2]);
                }
            } else {
                //不存在，其实也就相当于当前valuei > 被记录的valuei
                map.put(arr[0], arr[2]);
            }
            res = Math.max(res, arr[2]);
            index--;
        }
        return res;
    }
}
