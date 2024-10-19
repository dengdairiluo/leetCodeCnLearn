package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-19 19:54
 */
public class Q2728 {
    public int houseCount(Street street, int k) {
        for (int i = 0; i < k; i++) {
            street.closeDoor();
            street.moveRight();
        }
        int ans = 1;
        street.openDoor();
        street.moveRight();
        while (!street.isDoorOpen()) {
            ans++;
            street.moveRight();
        }
        return ans;
    }

    private static class Street {
        public Street(int[] doors) {

        }

        public void openDoor() {

        }

        public void closeDoor() {

        }

        public boolean isDoorOpen() {
            return false;
        }

        public void moveRight() {

        }

        public void moveLeft() {

        }
    }
}
