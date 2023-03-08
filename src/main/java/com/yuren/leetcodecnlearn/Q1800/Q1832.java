package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-19 23:03
 */
public class Q1832 {

    public boolean checkIfPangram(String sentence) {
        int[] array = new int[26];
        for (char c : sentence.toCharArray()) {
            array[c - 'a']++;
        }
        for (int i : array) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

}
