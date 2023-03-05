package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-05 22:25
 */
public class Q1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int r = d.get(0) - 1;
        int c = d.get(1) - 1;
        int ans = -1;
        while (r >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                if (c == 0) {
                    return 0;
                }
                ans = c;
                c--;
            } else {
                r--;
            }
        }
        return ans;
    }

    private static class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }

        public List<Integer> dimensions() {
            return new ArrayList<>();
        }
    }

    ;
}
