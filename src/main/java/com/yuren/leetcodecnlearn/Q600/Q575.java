package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-13 22:26
 */
public class Q575 {
    public int distributeCandies(int[] candyType) {
        int count = 0;
        boolean[] map = new boolean[200001];
        for (int x : candyType) {
            if (!map[x + 100000]) {
                count++;
                map[x + 100000] = true;
                if (count >= candyType.length / 2) {
                    break;
                }
            }
        }
        return count;
    }
}
