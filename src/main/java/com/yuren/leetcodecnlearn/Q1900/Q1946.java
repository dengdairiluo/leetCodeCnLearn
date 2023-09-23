package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-23 23:44
 */
public class Q1946 {
    public String maximumNumber(String num, int[] change) {
        boolean[] flag = new boolean[change.length];
        for (int i = 0; i < change.length; i++) {
            if (change[i] >= i) {
                // System.out.println(change[i]);
                // System.out.println(i);
                flag[i] = true;
            }
        }
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int x = chars[i] - '0';
            if (chars[i] == (char) (change[x] + '0')) {
                continue;
            }
            if (flag[x]) {
                chars[i] = (char) (change[x] + '0');
                for (int j = i + 1; j < chars.length; j++) {
                    x = chars[j] - '0';
                    if (flag[x]) {
                        // System.out.println();
                        // System.out.println(j);

                        chars[j] = (char) (change[x] + '0');
                    } else {
                        break;
                    }

                }
                break;
            }
        }
        return new String(chars);
    }
}
