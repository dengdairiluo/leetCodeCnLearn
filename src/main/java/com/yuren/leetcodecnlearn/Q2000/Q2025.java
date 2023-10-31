package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-31 23:45
 */
public class Q2025 {
    public int waysToPartition(int[] nums, int k) {
        long[] prevSum = new long[nums.length];
        prevSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prevSum[i] = prevSum[i - 1] + nums[i];
        }
        Long origSum = prevSum[nums.length - 1];
        HashMap<Long, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < prevSum.length - 1; i++) {
            if (!maps.containsKey(prevSum[i])) {
                maps.put(prevSum[i], new ArrayList<>());
            }
            maps.get(prevSum[i]).add(i);
        }
        int res = 0;
        if (Math.abs(origSum) % 2 == 0) {
            res = maps.getOrDefault(origSum / 2, new ArrayList<>()).size();
        }
        for (int i = 0; i < nums.length; i++) {
            int mdf = k - nums[i];
            int tempRes = 0;
            if (mdf != 0) {
                long mdfSum = origSum + mdf;
                if (Math.abs(mdfSum) % 2 == 1) {

                } else {
                    mdfSum /= 2;
                    // 在左边找
                    if (maps.containsKey(mdfSum)) {
                        List<Integer> lists = maps.get(mdfSum);
                        int index = findMostRight(lists, i);
                        if (index == -1) {

                        } else {
                            tempRes += index + 1;
                        }
                    }
                    // 在右边找
                    mdfSum = mdfSum - mdf;
                    if (maps.containsKey(mdfSum)) {
                        List<Integer> lists = maps.get(mdfSum);
                        int index = findMostLeft(lists, i);
                        if (index == -1) {

                        } else {
                            tempRes += lists.size() - index;
                        }
                    }
                }
            }
            res = Math.max(res, tempRes);
        }
        return res;
    }

    public int findMostRight(List<Integer> lists, int end) {
        int res = -1;
        int lo = 0;
        int hi = lists.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (lists.get(mid) < end) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public int findMostLeft(List<Integer> lists, int start) {
        int res = -1;
        int lo = 0;
        int hi = lists.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (lists.get(mid) >= start) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
