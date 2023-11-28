package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-28 23:50
 */
public class Q2080 {
    private List<List<Integer>> indicesMap;
    private int max = 0;
    private boolean IssingletonArr = true; /* <-.``判断数组是否只包含单个元素``: */

    public Q2080(int[] arr) {
        // <-.1计算arr中的最大值:
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (last == -1 || i == 0) {
                last = arr[i];
            } else {
                if (arr[i] != last) {
                    IssingletonArr = false;
                }
            }
            this.max = Math.max(this.max, arr[i]); /* <-.计算arr最大值: */
        }
        if (!IssingletonArr) { /* <-.`非单例数组`: */
            this.indicesMap = new ArrayList<>(max + 1);
            for (int i = 0; i <= max; i++) {
                this.indicesMap.add(new ArrayList<>());
            }
            for (int i = 0; i < arr.length; i++) {
                this.indicesMap.get(arr[i]).add(i);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (IssingletonArr) {
            if (value == this.max) {    /* <-.value等于唯一值max:*/
                return right - left + 1;
            } else {
                return 0;
            }
        } else {
            // 非单例数组:
            // <-.Corner-case:↓.
            if (value > this.max) {
                return 0;
            }
            List<Integer> indices = indicesMap.get(value);
            if (indices.size() == 0) {
                return 0;
            }
            int lo = indices.get(0);
            int hi = indices.get(indices.size() - 1);
            if (left > hi || right < lo) {
                return 0;
            }
            lo = ImplBinarySearch01(indices, left);
            hi = ImplBinarySearch02(indices, right);

            return (hi - lo + 1); /* <-.返回区间内的value元素频次:↑. */
        }
    }

    /* <-.1)二分搜索返回>=target的``最小值位置索引``:↓.(→.检测left) */
    private int ImplBinarySearch01(List<Integer> ls, int target) {
        int lo = 0;
        int hi = ls.size() - 1;
        int last = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int median = ls.get(mid);
            if (median < target) {
                lo = mid + 1;
            } else if (median >= target) {
                last = mid; //<-.往左找>=target的最小值:
                hi = mid - 1;
            }
        }
        if (last != -1)
            return last;
        return -lo - 1;
    }

    /* <-.2)二分搜索 <=target的``最大值位置索引``:↓.(←.检测right) */
    private int ImplBinarySearch02(List<Integer> ls, int target) {
        int lo = 0;
        int hi = ls.size() - 1;
        int last = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int median = ls.get(mid);
            if (median > target) {
                hi = mid - 1;
            } else if (median <= target) {
                last = mid;
                lo = mid + 1;
            }
        }
        if (last != -1)
            return last;
        return -lo - 1;
    }
}
