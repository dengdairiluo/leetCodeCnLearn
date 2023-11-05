package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-05 22:54
 */
public class Q2034 {
    HashMap<Integer, Integer> map;
    static final int len = 65536 * 2;
    static int[] max = new int[len * 2 + 4];
    static int[] min = new int[len * 2 + 4];
    int index, head, end;
    int newtime, newprice;

    public Q2034() {
        map = new HashMap<>();
        index = len;
        newtime = 0;
        Arrays.fill(max, 0);
        Arrays.fill(min, Integer.MAX_VALUE);
        max[0] = Integer.MAX_VALUE;
        min[0] = 0;
        head = len;
        end = len;
    }

    public void update(int timestamp, int price) {
        Integer pos = map.get(timestamp);
        if (pos == null) {
            pos = index++;
            map.put(timestamp, pos);
            if (pos > end) {
                head >>= 1;
                end = len + (end - len + 1) * 2 - 1;
            }
        }
        if (timestamp >= newtime) {
            newprice = price;
            newtime = timestamp;
        }
        max[pos] = price;
        min[pos] = price;
        for (int i = pos; i > head; ) {
            int x = Math.max(max[i], max[i ^ 1]);
            int up = i >> 1;
            if (max[up] == x) break;
            max[up] = x;
            i = up;
        }
        for (int i = pos; i > head; ) {
            int x = Math.min(min[i], min[i ^ 1]);
            int up = i >> 1;
            if (min[up] == x) break;
            min[up] = x;
            i = up;
        }
    }

    public int current() {
        return newprice;
    }

    public int maximum() {
        return max[head];
    }

    public int minimum() {
        return min[head];
    }

}
