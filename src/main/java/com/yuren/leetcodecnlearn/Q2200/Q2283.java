package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-08 21:43
 */
public class Q2283 {
    public boolean digitCount(String num) {
        int[] mp = new int[10];
        for (char c : num.toCharArray()) mp[c - '0']++;
        for (int i = 0; i < num.length(); i++) if (mp[i] != num.charAt(i) - '0') return false;
        return true;
    }
}
