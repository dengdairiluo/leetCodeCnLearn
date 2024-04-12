package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-05 23:11
 */
public class Q2094 {
    public int[] findEvenNumbers(int[] digits) {
        // 100 - 999
        int[] arr = new int[10];
        for (int digit : digits) {
            arr[digit]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 100; i < 999; i += 2) {
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;

            arr[a]--;
            arr[b]--;
            arr[c]--;

            if (arr[a] >= 0 && arr[b] >= 0 && arr[c] >= 0) {
                list.add(i);
            }

            arr[a]++;
            arr[b]++;
            arr[c]++;
        }

        int[] ans = new int[list.size()];

        int index = 0;
        for (int num : list) {
            ans[index++] = num;
        }

        return ans;
    }
}
