package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-13 21:57
 */
public class Q1146 {

    int snapId = 0;
    ArrayList<Integer>[] nums;

    public Q1146(int length) {
        nums = new ArrayList[length];
        snapId = 0;
    }

    public void set(int index, int val) {
        ArrayList<Integer> num = nums[index];
        if (num == null) {
            nums[index] = new ArrayList<>();
            nums[index].add(snapId);
            nums[index].add(val);
        } else {
            if (num.get(num.size() - 2) == snapId) {
                num.set(num.size() - 1, val);
            } else {
                num.add(snapId);
                num.add(val);
            }
        }

    }

    public int snap() {
        snapId++;
        return snapId - 1;

    }

    public int get(int index, int snapId) {
        ArrayList<Integer> num = nums[index];
        if (num == null) {
            return 0;
        }

        for (int i = Math.min(num.size() - 2, snapId * 2); i >= 0; i = i - 2) {
            if (num.get(i) <= snapId)
                return num.get(i + 1);
        }

        return 0;
    }
}
