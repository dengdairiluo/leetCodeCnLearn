package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-14 下午10:01
 */
public class Q2352 {
    public int equalPairs(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int[] ints : grid) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                //，由于数组中的数组不是0-9，因此当作大数计算不一定可以，用+=复杂化，反而可能起到类似hash的效果，
                // 但是某种情况也可能出错，所以，最好用字符串或者单个比较。
                num += num * 10 + ints[j];
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int num = 0;
            for (int[] ints : grid) {
                num += num * 10 + ints[j];
            }
            res += map.getOrDefault(num, 0);
        }
        return res;
    }
}
