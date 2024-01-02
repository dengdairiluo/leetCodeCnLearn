package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-02 23:08
 */
public class Q2150 {
    public List<Integer> findLonely(int[] nums) {

        int max = 0;
        for (int x : nums)
            if (x > max) max = x;

        int[] count = new int[max + 3];
        for (int x : nums)
            count[x + 1]++;

        List<Integer> result = new ArrayList<>();

        for (int x : nums) {
            if (count[x + 1] == 1 && count[x] == 0 && count[x + 2] == 0)
                result.add(x);
        }

        return result;
    }
}
