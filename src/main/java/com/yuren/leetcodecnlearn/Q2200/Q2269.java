package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-01 23:17
 */
public class Q2269 {
    public int divisorSubstrings(int num, int k) {
        int length = getLength(num);
        if (k == length) {
            return 1;
        }
        int beauty = 0;
        int subNum = num % 10;
        int temp = num / 10;
        int unit = 1;
        for (int i = 1; i < k; i++) {
            int digit = temp % 10;
            unit *= 10;
            subNum += digit * unit;
            temp /= 10;
        }
        if (subNum != 0 && num % subNum == 0) {
            beauty++;
        }
        while (temp != 0) {
            int digit = temp % 10;
            subNum = subNum / 10 + digit * unit;
            if (subNum != 0 && num % subNum == 0) {
                beauty++;
            }
            temp /= 10;
        }
        return beauty;
    }

    public int getLength(int num) {
        int length = 0;
        while (num > 0) {
            length++;
            num /= 10;
        }
        return length;
    }
}
