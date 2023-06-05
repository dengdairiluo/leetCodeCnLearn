package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-05 23:55
 */
public class Q1663 {
    private StringBuilder sb;

    public String getSmallestString(int n, int k) {
        k -= n;
        sb = new StringBuilder(n);
        n -= k / 25;
        if (n > 0) {
            fill(n - 1, 'a');
            sb.append((char) ('a' + k % 25));
        }
        fill(sb.capacity() - n, 'z');
        return sb.toString();
    }

    private void fill(int length, char val) {
        if (length <= 3) {
            if (length <= 0) {
                return;
            }

            while (--length >= 0) {
                sb.append(val);
            }
            return;
        }

        StringBuilder addend = new StringBuilder();
        addend.append(val);
        while (true) {
            if ((length & 1) == 1) {
                sb.append(addend);
            }
            if ((length >>>= 1) == 0) {
                return;
            }

            addend.append(addend);
        }
    }
}
