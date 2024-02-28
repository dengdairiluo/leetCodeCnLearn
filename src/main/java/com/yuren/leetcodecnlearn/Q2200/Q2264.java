package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-28 22:44
 */
public class Q2264 {

    public String largestGoodInteger(String num) {

        String[] e = {"000", "111", "222", "333", "444", "555",

                "666", "777", "888", "999"};

        for (int i = 9; i >= 0; i--) {

            if (num.contains(e[i])) {
                return e[i];
            }

        }

        return "";

    }
}
