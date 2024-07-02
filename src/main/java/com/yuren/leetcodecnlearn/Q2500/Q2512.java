package com.yuren.leetcodecnlearn.Q2500;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-02 下午11:01
 */
public class Q2512 {
    public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback,
                                     String[] report, int[] student_id, int k) {
        Set<String> ps = new HashSet<>();
        Set<String> ns = new HashSet<>();
        Collections.addAll(ps, positiveFeedback);
        Collections.addAll(ns, negativeFeedback);
        int n = report.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int sid = student_id[i];
            int t = 0;
            for (String s : report[i].split(" ")) {
                if (ps.contains(s)) {
                    t += 3;
                } else if (ns.contains(s)) {
                    t -= 1;
                }
            }
            arr[i] = new int[]{t, sid};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(arr[i][1]);
        }
        return ans;
    }
}
