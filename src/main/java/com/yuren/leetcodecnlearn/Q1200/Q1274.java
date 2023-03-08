package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-10 23:54
 */
public class Q1274 {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return countShips(sea, topRight, bottomLeft, false);
    }

    private int countShips(Sea sea, int[] topRight, int[] bottomLeft, boolean mustHaveShips) {
        int xTopRight = topRight[0];
        int yTopRight = topRight[1];
        int xBottomLeft = bottomLeft[0];
        int yBottomLeft = bottomLeft[1];

        if (xTopRight < xBottomLeft || yTopRight < yBottomLeft) return 0;

        // after this line of code, we can know that there must be at least one ship in the current rectangle. Do Binary Search here!
        if (mustHaveShips ? false : !sea.hasShips(topRight, bottomLeft)) return 0;


        if (xTopRight == xBottomLeft && yTopRight == yBottomLeft) return 1;

        // in the same x/column
        if (xTopRight == xBottomLeft) {
            int yMid = (yTopRight + yBottomLeft) / 2;

            int cntBottomHalf = countShips(sea, new int[]{xTopRight, yMid}, new int[]{xBottomLeft, yBottomLeft}, false);
            return cntBottomHalf + countShips(sea, new int[]{xTopRight, yTopRight}, new int[]{xBottomLeft, yMid + 1}, cntBottomHalf == 0);
        } else {
            int xMid = (xTopRight + xBottomLeft) / 2;

            int cntLeftHalf = countShips(sea, new int[]{xMid, yTopRight}, new int[]{xBottomLeft, yBottomLeft}, false);
            return cntLeftHalf + countShips(sea, new int[]{xTopRight, yTopRight}, new int[]{xMid + 1, yBottomLeft}, cntLeftHalf == 0);
        }
    }

    private static class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return false;
        }
    }
}
