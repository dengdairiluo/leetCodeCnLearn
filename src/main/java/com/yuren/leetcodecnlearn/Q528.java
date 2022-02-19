package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-19 23:33
 */
public class Q528 {
    // 桶编号 / 桶内编号 / 总数
    int bid, iid, tot;
    List<int[]> list = new ArrayList<>();
    public Q528(int[] w) {
        int n = w.length;
        double sum = 0, min = 1e9;
        for (int i : w) {
            sum += i;
            min = Math.min(min, i);
        }
        double minv = min / sum;
        int k = 1;
        while (minv * k < 1) k *= 10;
        for (int i = 0; i < n; i++) {
            int cnt = (int)(w[i] / sum * k);
            list.add(new int[]{i, cnt});
            tot += cnt;
        }
    }

    public int pickIndex() {
        if (bid >= list.size()) {
            bid = 0; iid = 0;
        }
        int[] info = list.get(bid);
        int id = info[0], cnt = info[1];
        if (iid >= cnt) {
            bid++; iid = 0;
            return pickIndex();
        }
        iid++;
        return id;
    }
}
