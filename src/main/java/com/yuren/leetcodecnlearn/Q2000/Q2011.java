package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-24 23:19
 */
public class Q2011 {
    public int finalValueAfterOperations(String[] ops) {
        return Arrays.stream(ops).mapToInt(s -> s.charAt(1) == '+' ? 1 : -1).sum();
    }
}
