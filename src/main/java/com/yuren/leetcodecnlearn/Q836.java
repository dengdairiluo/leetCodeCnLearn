package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-03 23:37
 */
public class Q836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }
        // left
        return !(rec1[2] <= rec2[0] ||
                // bottom
                rec1[3] <= rec2[1] ||
                // right
                rec1[0] >= rec2[2] ||
                // top
                rec1[1] >= rec2[3]);

    }
}
