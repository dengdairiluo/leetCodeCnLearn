package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-07 22:40
 */
public class Q1963 {
    public int minSwaps(String s) {
        int count = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    //得到]，res++
                    count = 0;
                    res++;
                }
            }
        }
        return (res + 1) / 2;
    }
}
