package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-03 23:46
 */
public class Q1657 {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 != len2) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < len1; i++) {
            arr1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            arr2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 25; i++) {
            if (arr1[i] == 0 && arr2[i] != 0 || arr2[i] == 0 && arr1[i] != 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < 26; j++) {
                    if (arr2[j] == arr1[i]) {
                        arr1[i] = 0;
                        arr2[j] = 0;
                        break;
                    }
                }
            }
        }
        for (Integer a : arr1) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
