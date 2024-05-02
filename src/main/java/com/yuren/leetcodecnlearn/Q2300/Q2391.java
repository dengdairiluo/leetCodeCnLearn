package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-02 下午10:45
 */
public class Q2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int lastm = 0, lastp = 0, lastg = 0;// 记录'M''P''G'的最后出现的位置
        for (int i = 0; i < garbage.length; i++) {
            String garbageStr = garbage[i];
            ans += garbageStr.length();
            for (Character c : garbageStr.toCharArray()) {
                if (c == 'M')
                    lastm = i;
                if (c == 'P')
                    lastp = i;
                if (c == 'G')
                    lastg = i;
            }
        }
        for (int i = 0; i < travel.length; i++) {
            if (lastg > i)
                ans += travel[i];
            if (lastm > i)
                ans += travel[i];
            if (lastp > i)
                ans += travel[i];
        }
        return ans;
    }
}
