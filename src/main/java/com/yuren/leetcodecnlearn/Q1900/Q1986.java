package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-12 22:32
 */
public class Q1986 {
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int low = 1;
        int high = tasks.length;
        while (low < high) {
            int numSession = (low + high) / 2;
            if (canWork(tasks, sessionTime, numSession, new int[tasks.length], tasks.length - 1)) {
                high = numSession;
            } else {
                low = numSession + 1;
            }
        }
        return low;
    }

    public boolean canWork(int[] tasks, int sessionTime, int numSession, int[] sessions, int tasksIdx) {
        if (tasksIdx < 0) return true;
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < numSession; i++) {
            if (!hs.add(sessions[i])) continue;
            if (sessions[i] + tasks[tasksIdx] > sessionTime) continue;
            sessions[i] += tasks[tasksIdx];
            if (canWork(tasks, sessionTime, numSession, sessions, tasksIdx - 1)) return true;
            sessions[i] -= tasks[tasksIdx];
        }
        return false;
    }
}
