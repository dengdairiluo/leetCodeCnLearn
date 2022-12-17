package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-11 23:41
 */
public class Q991 {
    public int brokenCalc(int startValue, int target) {
        long plus = 1;
        long value = startValue;
        long ans = 0;
        while (value < target) {
            value *= 2L;
            plus *= 2;
            ans += 1;
        }
        if (value == target) {
            return (int) ans;
        }
        long more = value - target;
        if (more == 1) {
            return (int) ans + 1;
        }
        long add = more % 2;
        long sub = more - add;
        while (sub != 0) {
            if (sub >= plus) {
                long t = sub / plus;
                ans += t;
                sub -= t * plus;
            } else {
                plus /= 2;
            }
        }
        return (int) (ans + add);
    }
}
