package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-16 23:09
 */
public class Q2240 {
    long sum = 0, mb = 0, mm = 0;
    int cost2;

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) {
            int temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }
        int left = 0, right = total / cost1;
        long diff2 = cost1 / cost2;
        long count1 = total / cost1;
        long count2 = total % cost1 / cost2;
        long sum2 = (right + 1) * (2 * count2 + right * diff2) / 2;
        this.mb = total - count1 * cost1 - count2 * cost2;
        this.mm = cost1 - diff2 * cost2;
        this.cost2 = cost2;
        dfs(left, right, 0);
        return sum + sum2 + count1 + 1;
    }

    private void dfs(int left, int right, long base) {
        long leftSurplusNum = (mb + left * mm - base * cost2) / cost2;
        long rightSurplusNum = (mb + right * mm - base * cost2) / cost2;
        if (leftSurplusNum == 0 && rightSurplusNum == 0) return;
        sum += (right - left + 1) * leftSurplusNum;
        if (leftSurplusNum == rightSurplusNum) return;
        int mid = (left + right) >> 1;
        dfs(left, mid, base + leftSurplusNum);
        dfs(mid + 1, right, base + leftSurplusNum);
    }
}
