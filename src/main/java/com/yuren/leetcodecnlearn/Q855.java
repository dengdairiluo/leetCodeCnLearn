package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-12 23:16
 */
public class Q855 {
    /**
     * 存储以 p 为起点的所有线段
     */
    private final Map<Integer, int[]> startMap;
    /**
     * 存储以 p 为终点的所有线段
     */
    private final Map<Integer, int[]> endMap;
    /**
     * 存储所有线段并排序
     */
    private int N;
    private final TreeSet<int[]> pq;

    public Q855(int n) {

        this.N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {

            int disA = distance(a); // 计算两个线段的长度
            int disB = distance(b);
            if (disA == disB) {
                return b[0] - a[0];
            }

            return disA - disB;
        });

        // 在有序集合中先放一个虚拟线段
        addInterval(new int[]{-1, N});
    }

    private int distance(int[] intv) { // 计算线段中点和左端点的距离

        int x = intv[0];
        int y = intv[1];
        if (x == -1) {
            return y;
        }
        if (y == N) {
            return N - 1 - x;
        }
        return (y - x) / 2;
    }

    /**
     * 删除线段
     *
     * @param intv
     */
    private void removeInterval(int[] intv) {

        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    /**
     * 增加线段
     *
     * @param intv
     */
    private void addInterval(int[] intv) {

        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    public int seat() {

        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            // 情况一：最左边没人，坐最左边
            seat = 0;
        } else if (y == N) {
            // 情况二：最右边没人，坐最右边
            seat = N - 1;
        } else {
            // 情况三：不是边界，就坐在中间
            seat = x + (y - x) / 2;
        }

        // 将最长的线段分成两段
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {

        // 将 p 的左右的线段找出来，即以 p 为起点和终点的线段
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);
        // 将两条线段合并为一条线段
        int[] merged = new int[]{left[0], right[1]};

        //删除旧线段，插入新线段
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }
}
