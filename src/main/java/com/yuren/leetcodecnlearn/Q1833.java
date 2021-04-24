package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-24 20:58
 */
public class Q1833 {

    private static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for(int cost : costs) {
            if (cost <= coins) {
                ans++;
                coins-=cost;
            } else {
                break;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] costs = new int[] {1,3,2,4,1};
        System.out.println(maxIceCream(costs, 7));
    }

}
