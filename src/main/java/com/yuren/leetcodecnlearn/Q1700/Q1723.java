package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-26 06:58
 */
public class Q1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        bucket = new int[k];
        Arrays.sort(jobs);
        int l = 0, r = jobs.length - 1, sum = 0;
        while (l < r) {
            int temp = jobs[l];
            jobs[l] = jobs[r];
            jobs[r] = temp;
            sum += temp + jobs[l];
            ++l;
            --r;
        }
        if (jobs.length % 2 == 1) {
            sum += jobs[jobs.length / 2];
        }
        l = jobs[0];
        r = sum;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (dfs(jobs, k, mid, 0)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    int[] bucket;

    private boolean dfs(int[] jobs, int k, int target, int index) {
        if (index == jobs.length) {
            bucket = new int[k];
            return true;
        }
        for (int i = 0; i < k; ++i) {
            if (i > 0 && bucket[i - 1] == bucket[i]) {
                continue;
            }
            if (bucket[i] + jobs[index] > target) {
                continue;
            }
            bucket[i] += jobs[index];
            if (dfs(jobs, k, target, index + 1)) {
                return true;
            }
            bucket[i] -= jobs[index];
        }
        return false;
    }
}
