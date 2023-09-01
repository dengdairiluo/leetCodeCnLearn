package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-01 23:25
 */
public class Q1897 {
    public boolean makeEqual(String[] words) {
        int len = words.length;
        int[] charCount = new int[129];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount[c]++;
            }
        }
        for (int i : charCount) {
            if (i % len != 0)
                return false;
        }
        return true;
    }
}
