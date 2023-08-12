package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-12 23:47
 */
public class Q1842 {
    public String nextPalindrome(String num) {
        int n = num.length();
        if (n < 3) {
            return "";
        }
        char[] chars = num.toCharArray();
        // 找到中间的位置往前进行搜索
        int mid = n / 2 - 1;
        int l = mid;
        while (l - 1 >= 0 && chars[l - 1] >= chars[l]) {
            l--;
        }
        if (l == 0) {
            // 此时的 num 已经是最大的了
            return "";
        }
        // 否则 num[l - 1] < num[l] 那么从 l 往后找到第一个 大于 num[l - 1] 的和他交换即可
        while (mid > l && chars[mid] <= chars[l - 1]) {
            mid--;
        }
        // 交换 num[mid] 和 mid[l - 1]
        // 对称的位置同理进行交换
        // x = n - 1 - mid
        swap(chars, mid, l - 1);
        swap(chars, n - 1 - mid, n - l);
        mid = n / 2;
        // num[l : mid] 进行降序排列
        Arrays.sort(chars, l, mid);
        for (int i = l; i < mid; i++) {
            chars[n - 1 - i] = chars[i];
        }
        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
