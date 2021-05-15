package com.yuren.leetcodecnlearn;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-15 17:44
 */
public class MST0101 {
    public boolean isUnique(String astr) {
        if (astr.length() > 1) {
            HashSet<Character> set = new HashSet<>(astr.length());
            for (char c : astr.toCharArray()) {
                if (!set.add(c)) {
                    return false;
                }
            }
        }
        return true;

    }
}
