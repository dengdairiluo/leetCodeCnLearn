package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-01 下午11:49
 */
public class Q2449 { public long makeSimilar(int[] nums, int[] target) {
    f(nums);
    f(target);
    long ans = 0L;
    for (int i = 0; i < nums.length; ++i)
        ans += Math.abs(nums[i] - target[i]);
    return ans / 4;
}

    private void f(int[] a) {
        // 由于元素都是正数，把奇数变成相反数，这样排序后奇偶就自动分开了
        for (int i = 0; i < a.length; ++i)
            if (a[i] % 2 != 0) a[i] = -a[i];
        Arrays.sort(a);
    }

}
