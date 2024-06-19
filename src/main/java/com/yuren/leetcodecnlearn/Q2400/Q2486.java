package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-19 下午11:33
 */
public class Q2486 {
    public int appendCharacters(String s, String t) {
        if (s.contains(t)) {
            return 0;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < s.length()) {
            index1 = s.indexOf(t.charAt(index2), index1);
            if (index1 == -1) {
                break;
            } else {
                index1++;
                index2++;
            }

        }
        return t.length() - index2;
    }
}
