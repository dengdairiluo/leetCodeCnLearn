package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-13 23:41
 */
public class Q1521 {
    class Solution {
        public int closestToTarget(int[] arr, int target) {
            int ans = (int) 1e9;
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, Math.abs(arr[i] - target));
                for (int j = i - 1; j >= 0; j--) {
                    if ((arr[i] & arr[j]) == arr[j]) {
                        break;
                    }
                    arr[j] &= arr[i];
                    ans = Math.min(ans, Math.abs(arr[j] - target));
                }
            }
            return ans;
        }
    }
}
