package com.yuren.leetcodecnlearn.Q1900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-07 22:51
 */
public class Q1968 {
    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return nums;
        }
        int[] res = new int[nums.length];
        if (length % 2 == 0) {
            toMaxHeap(nums, length - 1);
            res = midTravel(nums, length - 1);
            if (nums[length - 1] > res[length - 2]) {
                res[length - 1] = nums[length - 1];
            } else {
                res[length - 1] = res[length - 2];
                res[length - 2] = nums[length - 1];
            }
        } else {
            toMaxHeap(nums, length);
            res = midTravel(nums, length);
        }
        return res;
    }

    public int[] midTravel(int[] nums, int length) {
        List<Integer> temp = new ArrayList<>();
        midTravel(nums, length, temp, 0);
        int[] res = new int[nums.length];
        for (int i = 0; i < length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    // 中序遍历大顶堆
    public void midTravel(int[] nums, int length, List<Integer> res, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        if (left < length) {
            midTravel(nums, length, res, left);
        }
        res.add(nums[i]);
        if (right < length) {
            midTravel(nums, length, res, right);
        }
    }

    // 构建一个大顶堆
    private void toMaxHeap(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            swapMaxHeap(nums, i, length);
        }
    }

    private void swapMaxHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] < temp) {
                break;
            } else {
                nums[i] = nums[k];
                i = k;
            }
        }
        nums[i] = temp;
    }
}
