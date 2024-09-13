package com.yuren.leetcodecnlearn.Q2600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-13 23:55
 */
public class Q2659 {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; ++i)
            id[i] = i;
        Arrays.sort(id, (i, j) -> nums[i] - nums[j]);

        long ans = n; // 先把 n 计入答案
        BIT t = new BIT(n + 1); // 下标从 1 开始
        int pre = 1; // 上一个最小值的位置，初始为 1
        for (int k = 0; k < n; ++k) {
            int i = id[k] + 1; // 下标从 1 开始
            if (i >= pre) // 从 pre 移动到 i，跳过已经删除的数
                ans += i - pre - t.query(pre, i);
            else // 从 pre 移动到 n，再从 1 移动到 i，跳过已经删除的数
                ans += n - pre + i - k + t.query(i, pre - 1);
            t.inc(i); // 删除 i
            pre = i;
        }
        return ans;
    }

     private static class BIT {
        private final int[] tree;

        public BIT(int n) {
            tree = new int[n];
        }

        // 将下标 i 上的数加一
        public void inc(int i) {
            while (i < tree.length) {
                ++tree[i];
                i += i & -i;
            }
        }

        // 返回闭区间 [1, i] 的元素和
        public int sum(int x) {
            int res = 0;
            while (x > 0) {
                res += tree[x];
                x &= x - 1;
            }
            return res;
        }

        // 返回闭区间 [left, right] 的元素和
        public int query(int left, int right) {
            return sum(right) - sum(left - 1);
        }
    }

}
