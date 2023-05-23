package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-23 23:32
 */
public class Q1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char c = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; ++i) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time >= maxTime) {
                char cc = keysPressed.charAt(i);
                if (time == maxTime && cc <= c) {
                    continue;
                }
                maxTime = time;
                c = cc;
            }
        }
        return c;
    }
}
