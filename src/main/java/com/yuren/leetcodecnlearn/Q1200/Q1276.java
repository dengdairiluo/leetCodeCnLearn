package com.yuren.leetcodecnlearn.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-10 23:56
 */
public class Q1276 {

    public List<Integer> numOfBurgers(int t, int c) {
        if (t - c * 2 < 0 || c * 4 - t < 0 || (t - c * 2) % 2 != 0 || (c * 4 - t) % 2 != 0) {
            return new ArrayList<>();
        }
        return Arrays.asList((t - c * 2) / 2, (c * 4 - t) / 2);
    }

}
