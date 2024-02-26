package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-26 23:44
 */
public class Q2260 {
    public int minimumCardPickup(int[] cards) {
        int[] map = new int[1000001];
        int min = cards.length + 1;
        map[cards[0]] = 0;
        for (int i = 1; i < cards.length; i++) {
            if (map[cards[i]] > 0 || cards[i] == cards[0]) {
                min = Math.min(min, i - map[cards[i]] + 1);
            }
            map[cards[i]] = i;
        }
        return min > cards.length ? -1 : min;
    }
}
