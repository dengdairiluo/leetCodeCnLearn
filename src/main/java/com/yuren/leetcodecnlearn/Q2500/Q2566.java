package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-29 下午11:58
 */
public class Q2566 {
    static final int MIN_DIGIT = 0, MAX_DIGIT = 9;

    public int minMaxDifference(int num) {
        int maxUnit = getMaxUnit(num);
        return getMaxValue(num, maxUnit) - getMinValue(num, maxUnit);
    }

    public int getMaxUnit(int num) {
        int unit = 1;
        while (num / 10 > 0) {
            unit *= 10;
            num /= 10;
        }
        return unit;
    }

    public int getMaxValue(int num, int maxUnit) {
        int originalDigit = -1;
        while (maxUnit >= 1 && originalDigit < 0) {
            int digit = num / maxUnit % 10;
            if (digit < MAX_DIGIT) {
                originalDigit = digit;
            } else {
                maxUnit /= 10;
            }
        }
        for (int unit = maxUnit; unit >= 1; unit /= 10) {
            int digit = num / unit % 10;
            if (digit == originalDigit) {
                num -= originalDigit * unit;
                num += MAX_DIGIT * unit;
            }
        }
        return num;
    }

    public int getMinValue(int num, int maxUnit) {
        int originalDigit = num / maxUnit;
        for (int unit = maxUnit; unit >= 1; unit /= 10) {
            int digit = num / unit % 10;
            if (digit == originalDigit) {
                num -= originalDigit * unit;
                num += MIN_DIGIT * unit;
            }
        }
        return num;
    }
}
