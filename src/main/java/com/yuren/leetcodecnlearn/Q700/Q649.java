package com.yuren.leetcodecnlearn.Q700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-13 23:21
 */
public class Q649 {
    public String predictPartyVictory(String senate) {
        int Rnumber = 0;//R阵营总人数
        int Dnumber = 0;//D阵营总人数
        int curBanR = 0;//当前被ban
        int curBanD = 0;//当前被ban
        int totalBanR = 0;//被ban总数
        int totalBanD = 0;//被ban总数
        char[] chars = senate.toCharArray();
        boolean flag = true;
        while (true) {
            for (int i = 0; i < chars.length; i++) {
                char cur = chars[i];
                if (cur == 'R') {
                    if (flag)
                        Rnumber++;
                    if (curBanR == 0) {
                        curBanD++;
                        totalBanD++;
                        if (totalBanD == Dnumber && !flag) return "Radiant";
                    } else {
                        curBanR--;
                        chars[i] = 'r';
                    }
                } else if (cur == 'D') {
                    if (flag)
                        Dnumber++;
                    if (curBanD == 0) {
                        curBanR++;
                        totalBanR++;
                        if (totalBanR == Rnumber && !flag) return "Dire";
                    } else {
                        curBanD--;
                        chars[i] = 'd';
                    }
                }
            }
            flag = false;
            if (totalBanD >= Dnumber) return "Radiant";
            if (totalBanR >= Rnumber) return "Dire";
        }
    }
}
