package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-16 03:09
 */
public class Q2785 {
    public String sortVowels(String s) {
        int vowelsCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (isVowel(s.charAt(i))) {
                vowelsCount++;
            }
        }
        char[] vowels = new char[vowelsCount];
        for (int i = 0, j = 0; i < length; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels[j] = c;
                j++;
            }
        }
        Arrays.sort(vowels);
        char[] arr = s.toCharArray();
        for (int i = 0, j = 0; i < length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = vowels[j];
                j++;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
