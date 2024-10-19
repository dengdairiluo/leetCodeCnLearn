package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-19 20:06
 */
public class Q2729 {
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(2 * n).append(3 * n);
        int[] map = new int[10];
        char[] arr = sb.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] - '0']++;
        }
        for (int i = 1; i < 10; i++) {
            if (map[i] == 0 || map[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
