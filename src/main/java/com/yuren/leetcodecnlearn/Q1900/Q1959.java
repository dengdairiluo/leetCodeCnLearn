package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-30 23:44
 */
public class Q1959 {
    public int minSpaceWastedKResizing(int[] nums, int k) {

        int n = nums.length;

        if (k >= getResizeCount(nums)) {
            return 0;
        }

        int[] minSpaces = new int[n];
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            maxSize = Math.max(maxSize, nums[i]);
            minSpaces[i] = maxSize * (i + 1);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = n - 1; j > i; j--) {
                maxSize = nums[j];
                int minSpace = minSpaces[j - 1] + maxSize;
                for (int l = j - 1; l >= i; l--) {
                    maxSize = Math.max(maxSize, nums[l]);
                    minSpace = Math.min(minSpace, minSpaces[l - 1] + maxSize * (j + 1 - l));
                }
                minSpaces[j] = minSpace;
            }
            minSpaces[i] = minSpaces[i - 1] + nums[i];
        }
        int sumSize = 0;
        for (int num : nums) {
            sumSize += num;
        }
        return minSpaces[n - 1] - sumSize;
    }

    private int getResizeCount(int[] nums) {
        int count = 0;
        int preNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (preNum != num) {
                preNum = num;
                count++;
            }
        }
        return count;
    }
}
