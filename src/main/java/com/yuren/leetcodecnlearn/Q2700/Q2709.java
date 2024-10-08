package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-08 22:58
 */
public class Q2709 {
    int[] link, dic;

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;

        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        this.dic = new int[max + 1];
        this.link = new int[nums.length + 1];

        int num, last, end, head, fac;
        for (int idx = 0; idx < nums.length; idx++) {
            num = nums[idx];
            if (num == 1) return false;
            end = 1 + (int)Math.sqrt(num);
            head = update(idx + 1, num);
            if (link[head] == 0) link[head] = idx + 1;
            for (fac = 2; fac < end; fac++) {
                if (num % fac > 0) continue;
                head = update(head, fac);
                head = update(head, num/fac);
            }
        }

        int root = find(dic[nums[0]]);
        for (int idx = 1; idx < nums.length; idx++) {
            if (find(dic[nums[idx]]) != root) return false;
        }

        return true;
    }

    private int update(int head, int num) {
        if (dic[num] == 0) return dic[num] = head;
        return (link[head] = find(dic[num]));
    }

    private int find(int cur) {
        return link[cur] == cur ? cur : (link[cur] = find(link[cur]));
    }
}
