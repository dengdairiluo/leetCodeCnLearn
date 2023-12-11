package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-10 00:08
 */
public class Q2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int cnt = 0;
        int n = plants.length;
        int left = 0, right = n - 1;
        int resA = capacityA, resB = capacityB;
        while (left <= right) {
            if (left == right) {
                if (resA >= resB) {
                    if (resA < plants[left]) cnt++;
                } else {
                    if (resB < plants[right]) cnt++;
                }
            } else {
                if (resA < plants[left]) {
                    resA = capacityA;
                    cnt++;
                }
                resA -= plants[left];
                if (resB < plants[right]) {
                    resB = capacityB;
                    cnt++;
                }
                resB -= plants[right];
            }
            left++;
            right--;
        }

        return cnt;
    }
}
