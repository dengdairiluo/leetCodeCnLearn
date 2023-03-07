package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-01 15:53
 */
public class Q557 {

    private static String reverseWords1(String s) {
        String[] a = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = a[i].length() - 1; j >= 0; j--) {
                builder.append(a[i].charAt(j));
            }
            if (i != a.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static String reverseWords2(String s) {
        StringBuilder builder = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                builder.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                builder.append(' ');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords1(""));
    }

    public String reverseWords3(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1; // 更新start为下一个单词的左索引
                continue;
            }
            if (i == array.length - 1) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }

    private void reverse(char[] array, int l, int r) {
        while (l < r) {
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l += 1;
            r -= 1;
        }
    }
}
