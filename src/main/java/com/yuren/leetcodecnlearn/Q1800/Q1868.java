package com.yuren.leetcodecnlearn.Q1800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-21 23:34
 */
public class Q1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int idx1 = 0, idx2 = 0;
        int cnt1 = 0, num1 = 0, cnt2 = 0, num2 = 0;
        int cnt = 0, num = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (idx1 < encoded1.length || idx2 < encoded2.length) {
            if (cnt1 == 0) {
                cnt1 = encoded1[idx1][1];
                num1 = encoded1[idx1][0];
                idx1++;
            }
            if (cnt2 == 0) {
                cnt2 = encoded2[idx2][1];
                num2 = encoded2[idx2][0];
                idx2++;
            }
            int newNum = num1 * num2;
            int newCnt = Math.min(cnt1, cnt2);
            cnt1 -= newCnt;
            cnt2 -= newCnt;
            if (newNum == num) {
                cnt += newCnt;
            } else {
                if (cnt != 0) {
                    ans.add(Arrays.asList(num, cnt));
                }
                num = newNum;
                cnt = newCnt;
            }
        }
        if (cnt != 0) {
            ans.add(Arrays.asList(num, cnt));
        }
        return ans;
    }
}
