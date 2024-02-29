package com.yuren.leetcodecnlearn.Q2200;

import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-29 23:31
 */
public class Q2266 {
    public int countTexts(String pressedKeys) {
        LinkedList<Integer> l3 = new LinkedList<>();
        LinkedList<Integer> l4 = new LinkedList<>();
        int maxLen = 4, curLen = 1, curKey = pressedKeys.charAt(0);
        char[] chars = pressedKeys.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (curKey != chars[i]) {
                if (curKey == '7' || curKey == '9') l4.add(curLen);
                else l3.add(curLen);
                maxLen = Math.max(maxLen, curLen);
                curKey = chars[i];
                curLen = 1;
            } else curLen++;
        }
        if (curKey == '7' || curKey == '9') l4.add(curLen);
        else l3.add(curLen);
        maxLen = Math.max(maxLen, curLen);

        int m = 1000000007;
        long[] dp3 = new long[maxLen + 1];
        long[] dp4 = new long[maxLen + 1];
        int[] init = {1, 1, 2, 4};
        for (int i = 0; i < 4; i++) {
            dp3[i] = init[i];
            dp4[i] = init[i];
        }
        for (int i = 4; i <= maxLen; i++) {
            dp3[i] = (dp3[i - 1] + dp3[i - 2] + dp3[i - 3]) % m;
            dp4[i] = (dp4[i - 1] + dp4[i - 2] + dp4[i - 3] + dp4[i - 4]) % m;
        }

        long ans = 1;
        for (Integer len : l3) ans = ans * dp3[len] % m;
        for (Integer len : l4) ans = ans * dp4[len] % m;

        return (int) ans;
    }
}
