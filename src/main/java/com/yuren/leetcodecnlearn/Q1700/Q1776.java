package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-17 22:08
 */
public class Q1776 {
    public double[] getCollisionTimes(int[][] cars) {

        int[] stack = new int[cars.length];
        int top = -1;

        double[] collisionTimes = new double[cars.length];

        for (int i = cars.length - 1; i >= 0; i--) {
            int[] car = cars[i];
            collisionTimes[i] = -1;
            for (; top >= 0; top--) {
                int carIndex = stack[top];
                int[] collisionCar = cars[carIndex];
                if (collisionCar[1] < car[1]) {
                    double collisionTime = (double) (collisionCar[0] - car[0]) / (car[1] - collisionCar[1]);
                    if (collisionTimes[carIndex] < 0 || collisionTime <= collisionTimes[carIndex]) {
                        collisionTimes[i] = collisionTime;
                        break;
                    }
                }
            }
            stack[++top] = i;
        }
        return collisionTimes;
    }
}
