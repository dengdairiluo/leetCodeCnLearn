package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-16 03:05
 */
public class Q2663 {
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        // s 是一个美丽字符串，s 中没有长度为2或更长的回文子字符串。
        // 贪心，从后往前
        char[] cs = s.toCharArray();
        int mx = 'a' + k - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] == (char) mx) {
                continue;
            }
            int idx = cs[i] + 1;
            while (idx <= mx) {
                if (i > 0 && s.charAt(i - 1) == idx || i > 1 && s.charAt(i - 2) == idx) {
                    idx++;
                } else {
                    cs[i] = (char) idx;
                    // 修改 i 后面的字符，满足最美字符串的同时，让字典序最小。
                    for (int j = i + 1; j < n; j++) {
                        if (j == 1) {
                            if (cs[j - 1] == 'a') {
                                cs[j] = 'b';
                            } else {
                                cs[j] = 'a';
                            }
                        } else {
                            if (cs[j - 1] == 'a') {
                                if (cs[j - 2] == 'b') {
                                    cs[j] = 'c';
                                } else {
                                    cs[j] = 'b';
                                }
                            } else if (cs[j - 1] == 'b') {
                                if (cs[j - 2] == 'a') {
                                    cs[j] = 'c';
                                } else {
                                    cs[j] = 'a';
                                }
                            } else {
                                if (cs[j - 2] == 'a') {
                                    cs[j] = 'b';
                                } else {
                                    cs[j] = 'a';
                                }
                            }
                        }

                    }
                    return new String(cs);
                }
            }
        }
        return "";
    }
}
