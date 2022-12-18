package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-29 23:33
 */
public class Q1041 {
    public boolean isRobotBounded(String instructions) {
        char[] arr = instructions.toCharArray();
        int x = 0, y = 0;
        int[] direction = new int[]{0, 1, 2, 3};
        int count = 0;
        for (char c : arr) {
            if (c == 'L') {
                count++;
            } else if (c == 'R') {
                count--;
            } else if (c == 'G') {
                if (count % 4 == 0) {
                    y += 1;
                } else if (count % 4 == 1 || count % 4 == -3) {
                    x -= 1;
                } else if (count % 4 == 2 || count % 4 == -2) {
                    y -= 1;
                } else if (count % 4 == 3 || count % 4 == -1) {
                    x += 1;
                }
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return Math.abs(count % 4) != 0;
    }
}
