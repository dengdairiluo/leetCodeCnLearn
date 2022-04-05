package com.yuren.leetcodecnlearn;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-06 00:05
 */
public class Q632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        //因为每次都要找最小元素，所以维护一个最小堆比较合适
        PriorityQueue<NumGroup> numGroups = new PriorityQueue<>(Comparator.comparingInt(n -> n.num));

        int end = -100001;
        //记录每个数组当前的指针位置，一开始都指向第0个元素，即每个区间的最小元素
        int[] index = new int[nums.size()];

        //起始区间
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).get(0) > end) {
                end = nums.get(i).get(0);
            }
            NumGroup num = new NumGroup(nums.get(i).get(0), i);
            numGroups.offer(num);
        }

        int max = end;
        int start = numGroups.peek().num;
        int min = start;
        int len = end - start + 1;

        while (true) {
            //grp为当前最小元素的原数组号
            int grp = numGroups.poll().grp;
            //如果当前最小元素已经是原数组最大元素了，则退出
            if (index[grp] + 1 == nums.get(grp).size()) break;

            //索引++，并将当前最小元素的原数组中的下一个元素压入优先级队列
            index[grp]++;
            NumGroup n = new NumGroup(nums.get(grp).get(index[grp]), grp);
            numGroups.offer(n);
            //当前最大值
            if (n.num > max) max = n.num;
            min = numGroups.peek().num;
            //长度变小
            if (max - min + 1 < len) {
                start = min;
                end = max;
                len = max - min + 1;
            }
        }

        return new int[]{start, end};
    }

    private static class NumGroup {
        int num; //数值
        int grp; //组号

        public NumGroup(int num, int grp) {
            this.num = num;
            this.grp = grp;
        }
    }
}
