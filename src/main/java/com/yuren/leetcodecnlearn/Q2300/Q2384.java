package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-29 下午11:46
 */
public class Q2384 {
    public String largestPalindromic(String num) {
        // 定义暂存数组
        int[] dig = new int[10];
        StringBuilder s = new StringBuilder();
        // 统计各个数字出现的次数
        for (int i = 0; i < num.length(); i++) {
            dig[num.charAt(i) - '0']++;
        }
        // 从9开始遍历各个数字
        for (int i = 9; i >= 0; i--) {
            // 如果是偶数个，依次一个i，0最后填入
            if ((dig[i] > 0 && dig[i] % 2 == 0 && i != 0) ||
                    (i == 0 && s.length() != 0 && dig[i] > 0 && dig[i] % 2 == 0)) {
                while (dig[i] != 0) {
                    s.append(i);
                    dig[i] -= 2;
                }
            }
            // 如果是奇数个，依次填入i，直到为1，0最后填入
            if ((dig[i] > 1 && dig[i] % 2 == 1 && i != 0) ||
                    (i == 0 && s.length() != 0 && dig[i] > 1 && dig[i] % 2 == 1)) {
                while (dig[i] != 1) {
                    s.append(i);
                    dig[i] -= 2;
                }
            }
        }
        // 反转字符串
        StringBuilder sReverse = new StringBuilder(s).reverse();
        // 填入单个的数字
        for (int i = 9; i >= 0; i--) {
            if (dig[i] == 1) {
                s.append(i);
                break;
            }
        }
        // 加上之前反转的字符串
        s.append(sReverse);
        return s.length() == 0 ? "0" : s.toString();
    }
}
