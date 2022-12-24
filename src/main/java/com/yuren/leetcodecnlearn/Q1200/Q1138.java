package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-09 23:19
 */
public class Q1138 {
    public String alphabetBoardPath(String target) {
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) {
            pos[i] = new int[]{i % 5, i / 5};
        }
        int[] curr = new int[2];
        String s = target;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int chi = s.charAt(i) - 'a';
            int[] nch = pos[chi];
            int dx = nch[0] - curr[0], dy = nch[1] - curr[1];
            if (i == 0 || s.charAt(i - 1) < 'z') {
                char xc = 'L';
                if (dx > 0) xc = 'R';
                for (int j = 0; j < Math.abs(dx); j++) sb.append(xc);
                char yc = 'U';
                if (dy > 0) yc = 'D';
                for (int j = 0; j < Math.abs(dy); j++) sb.append(yc);
            } else {
                char yc = 'U';
                if (dy > 0) yc = 'D';
                for (int j = 0; j < Math.abs(dy); j++) sb.append(yc);
                char xc = 'L';
                if (dx > 0) xc = 'R';
                for (int j = 0; j < Math.abs(dx); j++) sb.append(xc);
            }
            sb.append('!');
            curr = nch;
        }
        return (sb.toString());
    }
}
