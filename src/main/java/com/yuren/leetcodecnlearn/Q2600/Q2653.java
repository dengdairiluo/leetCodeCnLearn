package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-10 23:17
 */
public class Q2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length, index = 0;
        int[] res = new int[n - k + 1];

        // 我们可以只关心滑动窗口中负数的个数，如果负数的个数大于了 x 那么，美丽值一定是某一个负数，如果负数的个数
        // 小于 x，那么，第 x 小的数一定是一个正数，是那个正数不重要，美丽值一定为 0。
        int[] fre = new int[51];        // fre[i] 表示 -i 的出现频次
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) fre[-nums[i]]++;
        }
        res[index++] = getBeautyNum(fre, x);


        int l = 0, r = k;
        while (r < n) {
            if (nums[r] < 0) fre[-nums[r]]++; r++;
            if (nums[l] < 0) fre[-nums[l]]--; l++;
            res[index++] = getBeautyNum(fre, x);
        }
        return res;
    }

    public int getBeautyNum(int[] fre, int x) {
        int cnt = 0;
        // 要求第 x 小，得从后向前遍历
        for (int i = 50; i > 0; i--) {
            if (fre[i] != 0) cnt += fre[i];
            if (cnt >= x) return -i;
        }
        return 0;
    }
}
