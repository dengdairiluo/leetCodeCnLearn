package com.yuren.leetcodecnlearn.Q2200;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-05 23:06
 */
public class Q2276 {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int cnt = 0;

    public Q2276() {

    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> interval = map.floorEntry(right);
        while (interval != null && interval.getValue() >= left) {
            int l = interval.getKey(), r = interval.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);
            cnt -= r - l + 1;
            map.remove(l);
            interval = map.floorEntry(right);
        }
        cnt += (right - left + 1);
        map.put(left, right);
    }

    public int count() {
        return cnt;
    }
}
