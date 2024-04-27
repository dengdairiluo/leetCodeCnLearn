package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-27 下午10:19
 */
public class Q2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffs = new int[n];
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            int diff = direction == 1 ? 1 : -1;
            diffs[start] += diff;
            if (end + 1 < n) {
                diffs[end + 1] -= diff;
            }
        }
        for (int i = 1; i < n; i++) {
            diffs[i] += diffs[i - 1];
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int index = (s.charAt(i) - 'a' + diffs[i]) % 26;
            if (index < 0) {
                index += 26;
            }
            sb.append((char) ('a' + index));
        }
        return sb.toString();
    }
}
