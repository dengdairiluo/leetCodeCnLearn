package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-16 23:08
 */
public class Q2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 > 0) return Collections.emptyList();
        List<Long> ans = new ArrayList<>();
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        int back = ans.size() - 1;
        ans.set(back, ans.get(back) + finalSum);
        return ans;
    }
}
