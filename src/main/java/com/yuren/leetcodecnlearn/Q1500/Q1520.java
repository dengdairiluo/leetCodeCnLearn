package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-12 23:30
 */
public class Q1520 {
    public List<String> maxNumOfSubstrings(String s) {

        int[][] posRange = new int[26][2];
        int n = s.length();
        for (int i = 0; i < 26; i++) {
            posRange[i] = new int[]{n, 0};
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int c = arr[i] - 'a';
            posRange[c][0] = Math.min(posRange[c][0], i);
            posRange[c][1] = Math.max(posRange[c][1], i);
        }

        int right = n;

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {

            if (i == posRange[arr[i] - 'a'][0]) {

                int newRight = checkSubstring(arr, i, posRange);

                if (newRight != -1) {

                    if (i <= right && result.size() != 0) {
                        //if we find valid char less than i
                        result.set(result.size() - 1, s.substring(i, newRight + 1));
                    } else {
                        result.add(s.substring(i, newRight + 1));
                    }

                    right = newRight;
                }
            }
        }

        return result;
    }

    int checkSubstring(char[] a, int i, int[][] posRange) {

        int right = posRange[a[i] - 'a'][1];

        for (int j = i; j <= right; ++j) {
            int c = a[j] - 'a';
            if (posRange[c][0] < i) {
                //it mean this char is illegal.
                //"abab" is "abab", not "bab"
                return -1;
            }
            right = Math.max(right, posRange[c][1]);
        }
        return right;
    }
}
