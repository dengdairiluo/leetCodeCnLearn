package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-02 22:41
 */
public class Q1464 {

    public int maxProduct(int[] nums) {
        int fst = 0, snd = 0;
        for (int num : nums) {
            if (num > fst) {
                snd = fst;
                fst = num;
            } else if (num > snd) {
                snd = num;
            }
        }
        return (fst - 1) * (snd - 1);
    }

}
