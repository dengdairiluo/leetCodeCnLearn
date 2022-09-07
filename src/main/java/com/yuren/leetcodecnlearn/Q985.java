package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-07 23:54
 */
public class Q985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                sum += num;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int val = query[0], index = query[1];
            int num = nums[index];
            if ((num & 1) == 0) {
                sum -= num;
            }
            num += val;
            if ((num & 1) == 0) {
                sum += num;
            }
            ans[i] = sum;
            nums[index] = num;
        }
        return ans;
    }
}
