package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-29 22:57
 */
public class Q1564 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);

        // replace the height of each warehouse with
        // the minimum height before it (including itself)
        int min = warehouse[0];
        for (int ii = 0; ii < warehouse.length; ii++) {
            if (warehouse[ii] < min) {
                min = warehouse[ii];
            }
            warehouse[ii] = min;
        }

        // from the back of the warehouse, push boxes
        int boxIdx = 0;
        int count = 0;
        for (int ii = warehouse.length - 1; ii >= 0; ii--) {
            if (boxIdx == boxes.length) {
                return boxes.length;
            }
            if (warehouse[ii] >= boxes[boxIdx]) {
                count++;
                boxIdx++;
            }
        }

        return count;
    }
}
