package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-12 23:50
 */
public class Q1845 {
    boolean[] isReserved;
    int index = 0;
    int availableUnreservedCount = 0;

    public Q1845(int n) {
        isReserved = new boolean[n + 1];
    }

    public int reserve() {

        if (availableUnreservedCount > 0) {
            for (int i = 1; i < isReserved.length; ++i) {
                if (!isReserved[i]) {
                    isReserved[i] = true;
                    availableUnreservedCount--;
                    return i;
                }
            }
        }

        ++index;
        isReserved[index] = true;
        return index;
    }

    public void unreserve(int seatNumber) {
        isReserved[seatNumber] = false;
        availableUnreservedCount++;
    }
}
