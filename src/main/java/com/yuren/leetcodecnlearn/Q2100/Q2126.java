package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-21 22:58
 */
public class Q2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        return asteroidsDfs(mass, asteroids, asteroids.length);
    }

    public boolean asteroidsDfs(int mass, int[] asteroids, int num) {
        if (num == 0) {
            return true;
        }
        int cur = num;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 && mass >= asteroids[i]) {
                mass += asteroids[i];
                if (mass > 100000) {
                    return true;
                }
                asteroids[i] = 0;
                cur--;
            }
        }
        if (cur == num) {
            return false;
        }
        return asteroidsDfs(mass, asteroids, cur);
    }
}
