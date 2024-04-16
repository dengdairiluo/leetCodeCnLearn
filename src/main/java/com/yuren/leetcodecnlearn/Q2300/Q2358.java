package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-16 下午11:56
 */
public class Q2358 {
    public int maximumGroups(int[] grades) {
        long len = grades.length;
        long ans = 1;
        long l = 1, r = len;
        while (l <= r) {
            long m = ((r - l) >> 1) + l; // 假设分成m组
            long need = (1 + m) * m / 2;// 分m组至少need个人，等差数列求和。
            if (need > len) { // 人不够
                r = m - 1;// 大了就缩
            } else { // 人有富余
                ans = m;// 先收了再说，可能是这个，也有可能存在一个大于当前m，但是仍然满足need<=len的数，需要向右找，所以
                l = m + 1; // 可以再挤一挤，试一试， 富余的人还有可能多分出组，需要继续尝试
            }
        }
        return (int) ans;
    }
}
