package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-09 22:52
 */
public class Q2285 {
    public long maximumImportance(int n, int[][] roads) {
        //map[i] 表示第i少条路的城市有多少条路（后面的排序后表示的意思）
        long[] map = new long[n];
        for (int[] road : roads) {
            map[road[0]]++;
            map[road[1]]++;
        }
        //城市数值
        int num = 1;
        //将这些城市按有道路数从小到大排序
        Arrays.sort(map);
        long ans = 0L;
        for (long l : map) {
            //道路重要性之和为==》   城市数值 *城市的道路数
            ans += l * num;
            num++;
        }
        return ans;
    }
}
