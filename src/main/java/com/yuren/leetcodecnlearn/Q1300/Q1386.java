package com.yuren.leetcodecnlearn.Q1300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 00:55
 */
public class Q1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int middle = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> occupied = new HashMap<>();
        for (int[] seat : reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                int origin = occupied.containsKey(seat[0]) ? occupied.get(seat[0]) : 0;
                int value = origin | (1 << (seat[1] - 2));
                occupied.put(seat[0], value);
            }
        }

        int ans = (n - occupied.size()) * 2;
        for (Map.Entry<Integer, Integer> entry : occupied.entrySet()) {
            int bitmask = entry.getValue();
            if (((bitmask | left) == left) || ((bitmask | middle) == middle) || ((bitmask | right) == right)) {
                ++ans;
            }
        }
        return ans;
    }
}
