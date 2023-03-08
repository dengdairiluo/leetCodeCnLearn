package com.yuren.leetcodecnlearn.Q1200;

import java.awt.Point;
import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-17 23:38
 */
public class Q1222 {
    List<List<Integer>> ans;

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < queens.length; i++) {
            set.add(new Point(queens[i][0], queens[i][1]));
        }
        ans = new ArrayList<>();
        int[] direction = new int[]{-1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1};
        for (int k = 0; k < direction.length; k += 2) {
            int x = direction[k], y = direction[k + 1];
            this.f(king[0], king[1], x, y, set);
        }
        return ans;
    }

    private boolean out(int x) {
        return x == -1 || x == 8;
    }

    private void f(int k1, int k2, int x, int y, Set<Point> set) {
        if (this.out(k1) || this.out(k2)) {
            return;
        }
        if (set.contains(new Point(k1, k2))) {
            ans.add(Arrays.asList(k1, k2));
        } else {
            this.f(k1 + x, k2 + y, x, y, set);
        }
    }

}
