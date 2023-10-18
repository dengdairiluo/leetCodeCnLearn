package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-18 23:17
 */
public class Q1999 {
    public int findInteger(int k, int digit1, int digit2) {
        if (digit1 > digit2) {
            int temp = digit1;
            digit1 = digit2;
            digit2 = temp;
        }


        for (int i = 0, upperLimit = 2; i < 10; ++i, upperLimit <<= 1) {
            for (int mask = 0; mask < upperLimit; mask++) {
                long curr = 0;
                for (int bit = (upperLimit >> 1); bit != 0; bit >>= 1)
                    curr = curr * 10 + (((mask & bit) == 0) ? digit1 : digit2);

                if (k < curr && curr <= Integer.MAX_VALUE && curr % k == 0)
                    return (int) curr;

            }
        }
        return -1;

    }
}
