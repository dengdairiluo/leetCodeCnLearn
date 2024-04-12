package com.yuren.leetcodecnlearn.Q900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-30 00:00
 */
public class Q967 {
    int n, k;
    private List<Integer> ans;

    public int[] numsSameConsecDiff(int n, int k) {
        ans = new ArrayList<>();
        this.n = n;
        this.k = k;
        for (int i = 1; i < 10; i++) {
            this.find(i, 1, i);
        }
        int[] ret = new int[ans.size()];
        int p = 0;
        for (Integer num : ans) {
            ret[p++] = num;
        }
        return ret;
    }

    private void find(int num, int index, int total) {
        if (index == n) {
            ans.add(total);
            return;
        }
        if (num + k < 10) {
            this.find(num + k, index + 1, total * 10 + num + k);
        }
        if (k != 0 && num - k > -1) {
            this.find(num - k, index + 1, total * 10 + num - k);
        }
    }
}
