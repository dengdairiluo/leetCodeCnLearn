package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-06 23:46
 */
public class Q1960 {
    public long maxProduct(String s) {
        int n = s.length();

        //---------- 马拉车算法求臂长数组 -------------//
        int[] armLen = new int[n];
        int center = -1;
        int maxR = -1;
        for (int i = 0; i < n; i++) {
            int curArmLen = 0;
            if (i <= maxR) {
                int mirror_i = 2 * center - i;
                int cur_min_len = Math.min(armLen[mirror_i], maxR - i);
                curArmLen = centerSpreadGetArmLen(s, i - cur_min_len, i + cur_min_len);
            } else {
                curArmLen = centerSpreadGetArmLen(s, i, i);
            }

            armLen[i] = curArmLen;
            if (i + curArmLen > maxR) {
                maxR = i + curArmLen;
                center = i;
            }
        }

        //--------- 前i个中，最大的臂长
        int[] prefixMaxArmLen = new int[n];
        int leftCenter = 0;
        for (int i = 1; i < n; i++) {
            while (leftCenter + armLen[leftCenter] < i)
                leftCenter++;
            prefixMaxArmLen[i] = Math.max(prefixMaxArmLen[i - 1], i - leftCenter);
        }

        //-------- 从i往右中，最大的臂长
        int[] suffixMaxArmLen = new int[n];
        int rightCenter = n - 1;
        for (int i = n - 2; i > -1; i--) {
            while (rightCenter - armLen[rightCenter] > i)
                rightCenter--;
            suffixMaxArmLen[i] = Math.max(suffixMaxArmLen[i + 1], rightCenter - i);
        }

        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            long lLen = 2L * prefixMaxArmLen[i] + 1;
            long rLen = 2L * suffixMaxArmLen[i + 1] + 1;
            res = Math.max(res, lLen * rLen);
        }
        return res;

    }


    public int centerSpreadGetArmLen(String s, int l, int r) {
        int n = s.length();
        while (0 <= l && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return (r - l - 2) / 2;
    }
}
