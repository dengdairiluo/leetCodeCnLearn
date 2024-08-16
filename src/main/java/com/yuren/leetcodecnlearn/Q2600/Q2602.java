package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-16 23:40
 */
public class Q2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        long[] s = new long[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];  // 记录前缀和
        List<Long> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long tmp = 0;
            int q = queries[i], j = 0;
            // for(;j < n;j ++) if(nums[j] > q) break;
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < q) l = mid + 1;
                else r = mid;
            }
            j = l;
            tmp = (long) (j) * q - s[j] + s[n] - s[j] - (long) (n - j) * q;
            ans.add(tmp);
        }

        return ans;
    }
}
