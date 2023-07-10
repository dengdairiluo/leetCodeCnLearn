package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-10 23:47
 */
public class Q1756 {
    ArrayList<Integer> res;

    public Q1756(int n) {
        res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
    }

    public int fetch(int k) {
        --k;
        int ret = res.get(k);
        res.remove(k);
        res.add(ret);
        return ret;
    }
}
