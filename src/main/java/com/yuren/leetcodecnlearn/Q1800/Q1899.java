package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-02 22:08
 */
public class Q1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        return hasMatch(triplets, target, 0) && hasMatch(triplets, target, 2) && hasMatch(triplets, target, 1);
    }

    public boolean hasMatch(int[][] triplets, int target[], int k) {
        for (int[] triplet : triplets) {
            if (triplet[k] == target[k]
                    && triplet[(k + 1) % 3] <= target[(k + 1) % 3]
                    && triplet[(k + 2) % 3] <= target[(k + 2) % 3]) {
                return true;
            }
        }
        return false;
    }
}
