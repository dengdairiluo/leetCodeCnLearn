package com.yuren.leetcodecnlearn.Q400;

import java.util.Random;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-23 23:31
 */
public class Q470 {
    private static final Random rand = new Random();

    private static int rand7() {
        return rand.nextInt(7);
    }

    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            if (num <= 40) {
                return 1 + num % 10;
            }
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60) {
                return 1 + num % 10;
            }
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) {
                return 1 + num % 10;
            }

        }
    }
}
