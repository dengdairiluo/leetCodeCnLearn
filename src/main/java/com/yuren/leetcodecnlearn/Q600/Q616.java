package com.yuren.leetcodecnlearn.Q600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-30 23:22
 */
public class Q616 {
    public String addBoldTag(String s, String[] dict) {
        List<int[]> ranges = new ArrayList<>();
        getRanges(s, dict, ranges);
        // 无替换区间
        if (ranges.isEmpty()) {
            return s;
        }

        // 区间合并
        LinkedList<int[]> merge = getMerge(ranges);

        // 替换处理
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < merge.size(); i++) {
            int[] r = merge.get(i);
            sb.append(s, start, r[0]).append("<b>").append(s, r[0], r[1] + 1).append("</b>");
            start = r[1] + 1;
        }
        if (start < s.length()) {
            sb.append(s.substring(start));
        }

        return sb.toString();
    }

    private LinkedList<int[]> getMerge(List<int[]> ranges) {
        LinkedList<int[]> merge = new LinkedList<>();
        merge.add(ranges.get(0));
        for (int i = 1; i < ranges.size(); i++) {
            int[] last = merge.getLast();
            int[] range = ranges.get(i);
            if (range[0] <= last[1] + 1) {
                merge.removeLast();
                merge.add(new int[]{Math.min(last[0], range[0]), Math.max(last[1], range[1])});
            } else merge.add(range);
        }
        return merge;
    }

    private void getRanges(String s, String[] dict, List<int[]> ranges) {
        for (String dic : dict) {
            if (s.contains(dic)) {
                helper(s, dic, 0, ranges);
            }
        }
        ranges.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
    }

    private void helper(String s, String dic, int i, List<int[]> ranges) {
        if (i < s.length() && s.substring(i).contains(dic)) {
            int start = s.indexOf(dic, i);
            int end = start + dic.length() - 1;
            ranges.add(new int[]{start, end});
            helper(s, dic, start + 1, ranges);
        }
    }
}
