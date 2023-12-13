package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-13 22:32
 */
public class Q2109 {
    public String addSpaces(String s, int[] spaces) {
        char[] arr = s.toCharArray();
        char[] newArr = new char[s.length() + spaces.length];

        int before = 0;
        for (int i = 0; i < spaces.length; i++) {
            int index = spaces[i];
            for (int j = before; j < index; j++) {
                newArr[j + i] = arr[j];
            }

            newArr[index + i] = ' ';
            before = index;
        }

        for (int i = spaces[spaces.length - 1]; i < s.length(); i++) {
            newArr[i + spaces.length] = arr[i];
        }

        return new String(newArr);
    }
}
