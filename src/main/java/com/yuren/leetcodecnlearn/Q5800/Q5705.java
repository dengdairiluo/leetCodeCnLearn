package com.yuren.leetcodecnlearn.Q5800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-04 18:31
 */
public class Q5705 {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1) - '0';
        return (x & 1) == 1 ? (y & 1) != 1 : (y & 1) != 0;
    }

}
