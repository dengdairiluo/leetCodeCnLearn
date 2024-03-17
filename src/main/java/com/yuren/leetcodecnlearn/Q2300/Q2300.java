package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-17 22:38
 */
public class Q2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int max = 0;
        for (int i : spells)
            if (i > max) {
                //取最大咒语
                max = i;
            }
        //计算有效药水边界
        int minPotion = (int) Math.min(100000, (success - 1) / max);
        int[] count = new int[max + 1];
        for (int potion : potions)
            if (potion > minPotion) {
                //咒语可用药水+1
                count[(int) ((success + potion - 1) / potion)]++;
            }
        for (int i = 1; i <= max; i++) {
            //前缀和累加可用药水
            count[i] += count[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = count[spells[i]];//取结果集
        return res;
    }
}
