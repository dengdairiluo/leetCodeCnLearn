package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-21 下午11:30
 */
public class Q2490 {
    public boolean isCircularSentence(String sentence) {
        String[] ss = sentence.split(" ");
        int n = ss.length;
        for (int i = 0; i < n; ++i) {
            if (ss[i].charAt(ss[i].length() - 1) != ss[(i + 1) % n].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
