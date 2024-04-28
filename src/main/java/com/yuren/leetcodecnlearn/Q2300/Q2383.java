package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-28 下午11:12
 */
public class Q2383 {
    public int minNumberOfHours(int eng, int exp, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; ++i) {
            int e = energy[i];
            if (eng <= e) {
                ans += e + 1 - eng;
                // 补到刚好超过
                eng = e + 1;
            }
            eng -= e;
            e = experience[i];
            if (exp <= e) {
                ans += e + 1 - exp;
                // 补到刚好超过
                exp = e + 1;
            }
            exp += e;
        }
        return ans;
    }
}
