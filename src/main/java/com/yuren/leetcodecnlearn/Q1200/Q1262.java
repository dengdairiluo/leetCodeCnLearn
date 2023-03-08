package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-08 23:32
 */
public class Q1262 {
    public int maxSumDivThree(int[] nums) {
        int sum = 0, min = 10001, min1 = 10001, min2 = 10001;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 3 == 0) {
            return sum;
        }
        if (sum % 3 == 1) {
            for (int num : nums) {
                if (num % 3 == 1) {
                    min = Math.min(min, num);
                } else if (num % 3 == 2) {
                    if (num < min1) {
                        min2 = min1;
                        min1 = num;
                    } else if (num < min2) {
                        min2 = num;
                    }
                }
            }
            sum = Math.max(sum - min, sum - min1 - min2);
        }
        if (sum % 3 == 2) {
            for (int num : nums) {
                if (num % 3 == 2) {
                    min = Math.min(min, num);
                } else if (num % 3 == 1) {
                    if (num < min1) {
                        min2 = min1;
                        min1 = num;
                    } else if (num < min2)
                        min2 = num;
                }
            }
            sum = Math.max(sum - min, sum - min1 - min2);
        }
        return sum;
    }
}
