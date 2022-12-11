package com.yuren.leetcodecnlearn.Q500;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-22 21:45
 */
public class Q469 {

    public long get(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        int dx1 = p1.get(0) - p2.get(0);
        int dx2 = p3.get(0) - p2.get(0);
        int dy1 = p1.get(1) - p2.get(1);
        int dy2 = p3.get(1) - p2.get(1);
        return (long) dx1 * dy2 - (long) dx2 * dy1;

    }

    public boolean isConvex(List<List<Integer>> points) {
        //点得数量
        int n = points.size();
        long pre = 0;
        for (int i = 0; i < n; i++) {
            //取得三个点

            long tmp = get(points.get(i), points.get((i + 1) % n), points.get((i + 2) % n));
            if (tmp != 0) {
                if (tmp * pre < 0) {
                    //不是凸
                    return false;
                }
                //轮替
                pre = tmp;
            }


        }
        return true;
    }
}
