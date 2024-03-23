package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-24 02:09
 */
public class Q2315 {
    public int countAsterisks(String s) {
        String[] strs = s.split("\\|");
        int count = 0;
        for (int i = 0; i < strs.length; i += 2) {
            char[] ch = strs[i].toCharArray();
            for (char c : ch) {
                if (c == '*') {
                    count++;
                }
            }
        }
        return count;

    }
}
