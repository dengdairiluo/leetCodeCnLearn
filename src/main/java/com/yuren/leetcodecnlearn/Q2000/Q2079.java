package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-27 23:29
 */
public class Q2079 {
    public int wateringPlants(int[] plants, int capacity) {
        // 总步数
        int count = 0;
        // 水桶总容量
        int max = capacity;

        for (int i = 0; i < plants.length; i++) {
            // 水充足的话
            if (capacity >= plants[i]) {
                // 走一步
                count += 1;
            } else {
                // 回去取水
                count += i;
                // 装满水
                capacity = max;
                // 走过去
                count += i + 1;
            }
            // 用掉水
            capacity -= plants[i];
        }

        return count;
    }
}
