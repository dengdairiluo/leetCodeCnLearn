package com.yuren.leetcodecnlearn.Q2700;



/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-30 23:59
 */
public class Q2753 {
    public int houseCount(Street street, int k) {
        int ans = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < k && !flag; i++) {
                if (street.isDoorOpen()) {
                    flag = true;
                } else {
                    street.moveRight();
                }
            }
            if (flag) {
                int count = 0;
                for (int i = 0; i < k && count == 0; i++) {
                    street.moveRight();
                    if (street.isDoorOpen()) {
                        count = i + 1;
                    }
                }
                ans = count;
                street.closeDoor();
            }
        }
        return ans;
    }

    private class Street {
        public Street(int[] doors) {

        }

        public void closeDoor() {

        }

        public boolean isDoorOpen() {
            return false;
        }

        public void moveRight() {

        }
    }
}
