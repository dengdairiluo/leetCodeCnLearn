package com.yuren.leetcodecnlearn.Q1100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-05 23:40
 */
public class Q1056 {
    private static final Map<Integer, Integer> MAP = new HashMap<Integer, Integer>() {
        {
            put(0, 0);
            put(1, 1);
            put(6, 9);
            put(8, 8);
            put(9, 6);
        }
    };

    public boolean confusingNumber(int n) {
        int num = n;
        int rotate = 0;
        while (n > 0) {
            int digit = n % 10;
            if (!MAP.containsKey(digit)) {
                return false;
            } else {
                rotate = rotate * 10 + MAP.get(digit);
            }
            n /= 10;
        }
        return rotate != num;
    }
}
