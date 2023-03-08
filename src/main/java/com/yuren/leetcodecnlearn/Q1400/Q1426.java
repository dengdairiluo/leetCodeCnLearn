package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-04 21:22
 */
public class Q1426 {
    public int countElements(int[] arr) {
        int[] map = new int[1001];
        for (Integer in : arr) {
            map[in]++;
        }
        int ans = 0;
        for (int i = 0; i < map.length - 1; i++) {
            if (map[i] >= 1 && map[i + 1] >= 1) {
                ans += map[i];
            }
        }
        return ans;
    }
}
