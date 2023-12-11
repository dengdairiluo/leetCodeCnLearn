package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-09 23:55
 */
public class Q2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        int n = security.length;
        List<Integer> result = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < n; ++i)
                result.add(i);
            return result;
        }

        int left = 0, right = 0;
        for (int i = 1; i < n - time; ++i) {
            if (security[i] <= security[i - 1])
                ++left;
            else
                left = 0;
            if (security[i + time - 1] <= security[i + time])
                ++right;
            else
                right = 0;
            if (left >= time && right >= time)
                result.add(i);
        }

        return result;

    }
}
