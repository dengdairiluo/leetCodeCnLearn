package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-05 22:56
 */
public class Q2035 {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;

        List<Integer>[] left, right;
        left = new ArrayList[n / 2 + 1];
        right = new ArrayList[n / 2 + 1];
        dfs(0, n / 2, 0, 0, nums, left);
        dfs(n / 2, n, 0, 0, nums, right);

        int answer = (int) 1e9;
        for (int i = 0; i <= n / 2; i += 1) {
            if (left[i] != null)
                Collections.sort(left[i]);
        }

        for (int i = 0; i <= n / 2; i += 1) {
            if (left[n / 2 - i] == null || right[i] == null) continue;
            for (int x : right[i]) {
                int l = 0, r = left[n / 2 - i].size() - 1;
                while (l < r) {
                    int m = (l + r) >> 1;
                    if (left[n / 2 - i].get(m) >= sum / 2 - x) r = m;
                    else l = m + 1;
                }
                answer = Math.min(answer, Math.abs(sum - 2 * (x + left[n / 2 - i].get(l))));
                if (l > 0) {
                    l--;
                    answer = Math.min(answer, Math.abs(sum - 2 * (x + left[n / 2 - i].get(l))));
                }
            }
        }
        return answer;

    }

    public void dfs(int i, int x, int sum, int length, int[] nums, List<Integer>[] list) {
        if (i == x) {
            if (list[length] == null)
                list[length] = new ArrayList<>();
            list[length].add(sum);
        } else {
            dfs(i + 1, x, sum + nums[i], length + 1, nums, list);
            dfs(i + 1, x, sum, length, nums, list);
        }
    }
}
