package com.yuren.leetcodecnlearn.Q1300;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 00:56
 */
public class Q1387 {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 0);
        init();
    }

    static void init() {
        for (int i = 1; i <= 1000; i++) {
            map.put(i, get(i));
        }
    }

    static int get(int num) {
        Integer val = map.get(num);
        if (val != null) {
            return val;
        }
        if (num == 1) {
            return 0;
        }
        if ((num & 1) == 0) {
            val = get(num >> 1) + 1;
        } else {
            val = get(3 * num + 1) + 1;
        }
        map.put(num, val);
        return val;
    }

    public static void main(String[] args) {
        // new Solution2().getKth(12, 15, 2);
    }

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = lo; i <= hi; i++) {
            int steps = -((map.get(i) << 10) | i);
            if (pq.size() < k) {
                pq.add(steps);
            } else {
                int top = pq.peek();
                if (steps > top) {
                    pq.remove();
                    pq.add(steps);
                }
            }
        }
        return (-pq.peek()) & 0x3ff;
    }
}
