package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-06 23:52
 */
public class Q982 {
    public int countTriplets(int[] arr) {
        //遍历数组， 确定形如100..00的上界， 以便之后可以用k-1作为掩码
        int k = 1;
        for (int item : arr) {
            while (k <= item) {
                k <<= 1;
            }
        }
        //记录对于每个特定的值， 数组里位或他能等于0的元素数量
        int[] mem = new int[k];
        for (int item : arr) {
            //所有1的位置和item完全无重合的值位与item都是0， 需要在特定mask之下降序遍历
            int mask = (k - 1) ^ item;
            int i = mask;
            while (true) {
                mem[i]++;
                if (i == 0) {
                    break;
                }
                //关键算法，别记错了
                i = (i - 1) & mask;
            }
        }
        int ans = 0;
        for (int a : arr) {
            for (int b : arr) {
                //利用之前的mem累加出答案
                ans += mem[a & b];
            }
        }
        return ans;
    }
}
