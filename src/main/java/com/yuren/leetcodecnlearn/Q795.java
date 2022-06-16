package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-16 23:40
 */
public class Q795 {
    public int preimageSizeFZF(int k) {
        return k % 61035156 % 12207031 % 2441406 % 488281 % 97656 % 19531 % 3906 % 781 % 156 % 31 == 30 ? 0 :
                (k % 61035156 % 12207031 % 2441406 % 488281 % 97656 % 19531 % 3906 % 781 % 156 % 31 % 6 / 5 == 0 ? 1 : 0) * 5;
    }
}
