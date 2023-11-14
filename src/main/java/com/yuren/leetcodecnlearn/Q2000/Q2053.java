package com.yuren.leetcodecnlearn.Q2000;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-14 23:19
 */
public class Q2053 {
    HashSet<String> set = new HashSet<>();
    HashSet<String> deleted = new HashSet<>();

    public String kthDistinct(String[] arr, int k) {
        for (String s : arr) {
            if (!set.add(s)) {
                deleted.add(s);
            }
        }

        int count = 0;
        for (String s : arr) {
            if (!deleted.contains(s)) {
                ++count;
                if (k == count) {
                    return s;
                }
            }
        }

        return "";
    }
}
