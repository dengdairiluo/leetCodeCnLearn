package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-22 22:56
 */
public class Q670 {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIdx = chars.length - 1;
        int[] maxArr = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIdx]) {
                maxIdx = i;
            }
            maxArr[i] = maxIdx;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[maxArr[i]] != chars[i]) {
                char temp = chars[maxArr[i]];
                chars[maxArr[i]] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
