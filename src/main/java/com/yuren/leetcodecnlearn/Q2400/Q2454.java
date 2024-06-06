package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-05 下午11:49
 */
public class Q2454 {
    public int[] secondGreaterElement(int[] nums) {

        int n = nums.length;
        int[] stack1 = new int[n], stack2 = new int[n];
        int top1 = -1, top2 = -1;

        int[] result = new int[n];
        stack1[++top1] = 0;
        result[0] = -1;

        for (int i = 1; i < n; i++) {
            result[i] = -1;
            while (top2 >= 0 && nums[i] > nums[stack2[top2]]) {
                result[stack2[top2]] = nums[i];
                top2--;
            }

            int temp = 0;
            while (top1 >= 0 && nums[i] > nums[stack1[top1]]) {
                top1--;
                temp++;
            }

            for (int j = 1; j <= temp; j++)
                stack2[++top2] = stack1[top1 + j];

            stack1[++top1] = i;
        }

        return result;
    }
}
