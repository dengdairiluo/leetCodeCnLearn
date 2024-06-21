package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-21 下午11:32
 */
public class Q2491 {
    int[] vis = new int[1000 + 1];//用来标记

    public long dividePlayers(int[] skill) {

        //求出skill的和
        long sum = 0;
        int n = skill.length;
        for (int k : skill) {
            sum += k;
            //标记哪些数字出现过，并记录次数
            vis[k]++;
        }
        //如果不能整除一定不符合划分原则
        if (n >= 2 && sum % (n / 2) != 0)
            return -1;

        long cnt = sum / (n / 2);
        //遍历所有元素
        for (int j : skill) {
            //若没有与之和为cnt则不满足要求
            if (vis[(int) (cnt - j)] == 0)
                return -1;
            vis[(int) (cnt - j)]--;//匹配到次数减一
        }
        //记录结果
        long ans = 1;
        for (int j : skill) {
            //求出每个数对应的乘积和在除以2就是最终结果
            ans += j * (cnt - j);
        }
        return ans / 2;
    }
}
