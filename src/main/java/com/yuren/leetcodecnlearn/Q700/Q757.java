package com.yuren.leetcodecnlearn.Q700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-31 07:15
 */
public class Q757 {
    class LT {
        int start, end, num;
        LT left, right;

        public LT(int s, int e) {
            start = s;
            end = e;
        }

        public void insert(int val) {
            num++;
            if (start < end) {
                int mid = (start + end) / 2;
                if (left == null) {
                    left = new LT(start, mid);
                    right = new LT(mid + 1, end);
                }

                if (mid >= val) {
                    left.insert(val);
                } else {
                    right.insert(val);
                }
            }
        }

        public int count(int s, int e) {
            if (num == 0) {
                return 0;
            }
            if (start >= s && end <= e) {
                return num;
            }
            int mid = (start + end) / 2;
            int ret = 0;
            if (mid >= s) {
                ret += left.count(s, e);
            }
            if (mid < e) {
                ret += right.count(s, e);
            }
            return ret;
        }
    }

    class Interval implements Comparable<Interval> {
        int start;
        Integer end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval interval) {
            return end.compareTo(interval.end);
        }
    }

    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalList);
        Set<Integer> picked = new HashSet<>();
        LT lt = new LT(0, 100000000);
        for (int i = 0; i < n; i++) {
            int x = intervalList.get(i).start;
            int y = intervalList.get(i).end;
            int cou = lt.count(x, y);
            // System.out.println(cou);
            if (cou < 1 || (cou < 2 && picked.contains(y))) {
                picked.add(y - 1);
                lt.insert(y - 1);
                //     System.out.println(y-1);
            }
            if (cou < 2 && !picked.contains(y)) {
                picked.add(y);
                lt.insert(y);
                //      System.out.println(y);
            }

        }
        return picked.size();
    }
}
