package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-22 23:25
 */
public class Q1318 {
    public int minFlips(int a, int b, int c) {
        int val1 = 0, val2 = 0, val3 = 0;
        //记录翻转的次数
        int ans = 0;
        while (a != 0 || b != 0 || c != 0) {
            //获取a,b,c的最低位va11,val2,val3
            val1 = a & 1;
            val2 = b & 1;
            val3 = c & 1;
            //讨论val3的情况
            if (val3 == 0) {
                if (val1 == 1) {
                    if (val2 == 1) ans += 2;
                    else ans++;
                } else if (val2 == 1) {
                    if (val1 == 1) ans += 2;
                    else ans++;
                }
            } else {
                if (val1 == 0 && val2 == 0) ans++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return ans;
    }
}
