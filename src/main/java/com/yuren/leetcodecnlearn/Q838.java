package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-05 23:06
 */
public class Q838 {
    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length, i = 0;
        char left = 'L';
        while (i < n) {
            int j = i;
            // 找到一段连续的没有被推动的骨牌
            while (j < n && s[j] == '.') {
                j++;
            }
            char right = j < n ? s[j] : 'R';
            // 方向相同，那么这些竖立骨牌也会倒向同一方向
            if (left == right) {
                while (i < j) {
                    s[i++] = right;
                }
                // 方向相对，那么就从两侧向中间倒
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }
}
