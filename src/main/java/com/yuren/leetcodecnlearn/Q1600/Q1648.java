package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-31 23:55
 */
public class Q1648 {
    public int maxProfit(int[] inventory, int orders) {
        /*
         按照数据量级，n2肯定是超时的，直接模拟会超时的
         直接模拟就是每次拿出最大的数，减一后放回排好序的堆中，然后直到orders为0
         二分或者排序+遍历
         贪心的思想：取完所有的小球时，总会剩下一个最大的值，二分找出这个最大值
         */
        long mod = (long) 1e9 + 7, res = 0;
        int l = 0, r = 0;
        for (int num : inventory) {
            if (r < num) {
                r = num;
            }
        }

        while (l < r) {
            int mid = (l + r) / 2;
            if (check(inventory, mid, orders)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        for (int num : inventory) {
            if (num > l) {
                res += (num + l + 1L) * (num - l) / 2;
                orders -= num - l;
            }
        }
        res += ((long) l) * orders;
        return (int) (res % mod);
    }

    /**
     * 判断以prices为底的时候，是不是可以满足要求
     *
     * @param nums
     * @param price
     * @param orders
     * @return
     */
    public boolean check(int[] nums, int price, int orders) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.max(num - price, 0);
            if (sum >= orders) {
                return true;
            }
        }
        return false;
    }
}
