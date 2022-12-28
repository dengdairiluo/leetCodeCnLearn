package com.yuren.leetcodecnlearn.Q1800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1762 {
    private static int[] findBuildings(int[] heights) {
        List<Integer> lookList = new ArrayList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                lookList.add(i);
                max = heights[i];
            }
        }

        int len = lookList.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = lookList.get(len - 1 - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] source = new int[]{4, 2, 3, 1};
        int[] res = findBuildings(source);
        System.out.println(Arrays.toString(res));
    }
}
