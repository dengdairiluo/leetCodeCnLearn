package com.yuren.leetcodecnlearn.Q2500;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-13 下午11:28
 */
public class Q2534 {
    static int ENTER = 0;
    static int EXIT = 1;

    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] ans = new int[n];
        Queue<Integer> enter = new ArrayDeque<>();
        Queue<Integer> exit = new ArrayDeque<>();
        int door = EXIT;
        int i = 0;
        for (int time = 0; i < n || !enter.isEmpty() || !exit.isEmpty(); time += 1) {
            while (i < n && arrival[i] <= time) {
                if (state[i] == ENTER) {
                    enter.add(i);
                } else {
                    exit.add(i);
                }
                i++;
            }
            if (!exit.isEmpty() && !enter.isEmpty()) {
                if (door == ENTER) {
                    ans[enter.poll()] = time;
                } else {
                    ans[exit.poll()] = time;
                }
            } else if (!exit.isEmpty()) {
                ans[exit.poll()] = time;
                door = EXIT;
            } else if (!enter.isEmpty()) {
                ans[enter.poll()] = time;
                door = ENTER;
            } else {
                door = EXIT;
                time = arrival[i] - 1;
            }
        }
        return ans;
    }
}
