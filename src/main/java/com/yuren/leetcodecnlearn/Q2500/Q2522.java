package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-08 上午12:04
 */
public class Q2522 {
    public int minimumPartition(String s, int k) {
        int temp = k;
        int cnt = 0;
        int ans = 0;
        while (temp > 0) {
            //先行计算出k位数
            temp /= 10;
            cnt++;
        }
        int i = 0;
        int n = s.length();
        while (i < n) {
            int x = 0;
            /*贪心，直接取出字符串中的对应k的位数长度的数字
            字符串中多取一位肯定比k大，少取一位便有可能不是最优解*/
            for (int j = i; j < n && j < i + cnt; j++) {
                x = x * 10 + (s.charAt(j) - '0');
            }
            if (x <= k) {
                //理想情况，答案加一，游标i加k的位数长度
                ans++;
                i += cnt;
            } else if (x > k && cnt == 1) {
                // 只有k为个位数的情况且x > k才返回-1
                return -1;
            } else {
                //x > k,但是k不是个位数，那么x少取一位即可，即游标i的位置移动 cnt - 1
                ans++;
                i += cnt - 1;
            }
        }
        return ans;
    }
}
