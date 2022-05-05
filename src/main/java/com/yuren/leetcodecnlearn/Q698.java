package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-05 22:37
 */
public class Q698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 边界条件
        if (k > nums.length) return false;
        int sum = 0;
        for (int x : nums) sum += x;
        if (sum % k != 0) return false;

        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
        int target = sum / k;   // 理论上每个桶应该装的数字之和
        // 先将数组排序，能够更好地剪枝，降序排列
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // DFS 穷举，nums 是否能够划分为 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }

    // DFS 递归穷举 nums 中每个数字
    public boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        // base case
        if (index == nums.length) {
            // nums[] 遍历完了，这时候说明所有数都找到了桶，如果没找到的话会在bucket[i] == 0被剪掉
            return true;
        }
        // 穷举 nums[index] 可以装入的桶
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝，这个桶装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 将 nums[index] 装入桶 bucket[i] 中
            bucket[i] += nums[index];
            // 递归下一个数字的选择
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
            // 这里可能index还没到nums.length，但是出现了无法凑成target的数，所以直接返回break，然后fasle就行
            if (bucket[i] == 0) {
                // nums[index] 找不到可以凑成 target 的数
                break;
            }
        }
        // nums[index] 装入哪个桶都不行
        return false;
    }
}
