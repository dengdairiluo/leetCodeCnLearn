package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-02 下午10:34
 */
public class Q2390 {
    public String removeStars(String s) {
        StringBuilder st = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                st.deleteCharAt(st.length() - 1);
            } else {
                st.append(c);
            }
        }
        return st.toString();
    }
}
