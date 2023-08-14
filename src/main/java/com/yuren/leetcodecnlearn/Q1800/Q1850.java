package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-14 23:36
 */
public class Q1850 {
    public int getMinSwaps(String num, int k) {
        char[] nums = num.toCharArray();
        int n = nums.length;
        while (k > 0) {
            int i = n - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) i--;
            if (i >= 0) {
                int j = n - 1;
                while (j > i && nums[i] >= nums[j]) j--;
                char c = nums[i];
                nums[i] = nums[j];
                nums[j] = c;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                char c = nums[l];
                nums[l] = nums[r];
                nums[r] = c;
                l++;
                r--;
            }
            k--;
        }
        char[] ori = num.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != ori[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (ori[j] == nums[i]) {
                        ans += j - i;
                        while (j > i) {
                            char c = ori[j];
                            ori[j] = ori[j - 1];
                            ori[j - 1] = c;
                            j--;
                        }
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
