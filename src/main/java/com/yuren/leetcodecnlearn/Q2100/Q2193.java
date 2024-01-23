package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-23 22:43
 */
public class Q2193 {
    char[] chars;
    int[] count = new int[26];
    int length;

    public int minMovesToMakePalindrome(String s) {
        length = s.length();
        chars = s.toCharArray();
        // 做一个计数，用于后面判断，是不是奇数
        for (char c : chars) {
            count[c - 'a']++;
        }
        return dp(0);
    }

    private int dp(int i) {

        if (i == length / 2 + 1) {
            return 0;
        }

        char left = chars[i];
        char right = chars[length - 1 - i];

        // System.out.println("start: " + i + "  " + chars[i] + "   " + chars[length - 1 - i]);
        int ans = 0;
        // 不需要动
        if (left == right) {
            count[left - 'a'] -= 2;
        }
        // 如果有一边，是唯一一个数，必须换掉
        else if (count[left - 'a'] == 1) {
            int idx = i + 1;
            while (chars[idx] != right) {
                idx++;
            }
            ans = idx - i;
            System.arraycopy(chars, i, chars, i + 1, ans);
            chars[i] = right;
            count[right - 'a'] -= 2;
        }
        // 否则随便换一个，换右边
        else {
            int idx = length - 1 - i - 1;
            while (chars[idx] != left) {
                idx--;
            }
            ans = length - 1 - i - idx;
            System.arraycopy(chars, idx + 1, chars, idx, ans);
            chars[length - 1 - i] = left;
            count[left - 'a'] -= 2;
        }

        // System.out.println("end: " + chars[i] + "   " + chars[length - 1 - i] + "  " + ans);

        return ans + dp(i + 1);
    }
}
