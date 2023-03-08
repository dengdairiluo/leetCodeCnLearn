package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-11 00:00
 */
public class Q1279 {
    private int current;

    public Q1279() {
        current = 1;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized (this) {
            if (current == roadId) {
                crossCar.run();
            } else {
                turnGreen.run();
                crossCar.run();
                current = roadId;
            }
        }
    }
}
