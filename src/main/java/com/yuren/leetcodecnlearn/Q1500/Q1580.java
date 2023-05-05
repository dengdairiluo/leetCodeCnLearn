package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-05 23:27
 */
public class Q1580 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        Arrays.sort(boxes);
        int ans = 0;
        int l = 0, r = n - 1;
        for (int i = boxes.length - 1; i >= 0; --i) {
            int height = boxes[i];
            if (l > r) {
                break;
            }
            if (height > warehouse[l] && height > warehouse[r]) {
                continue;
            }
            ++ans;
            if (warehouse[l] > warehouse[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
