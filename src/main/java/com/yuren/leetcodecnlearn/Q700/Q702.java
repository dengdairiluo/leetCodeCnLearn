package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-23 22:29
 */
public class Q702 {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) {
            return 0;
        }

        // search boundaries
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        // binary search
        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);

            if (num == target) {
                return pivot;
            }
            if (num > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        // there is no target element
        return -1;
    }

    interface ArrayReader {
        int get(int index);
    }
}
