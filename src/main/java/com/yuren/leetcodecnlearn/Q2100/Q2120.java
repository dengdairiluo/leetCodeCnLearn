package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-18 23:36
 */
public class Q2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] answer = new int[len];
        int x, y;
        char[] commands = s.toCharArray();
        for (int start = 0; start < len; start++) {
            int count = 0;
            x = startPos[1];
            y = startPos[0];
            loop:
            for (int i = start; i < len; i++) {
                switch (commands[i]) {
                    case 'R': {
                        if (++x == n) {
                            break loop;
                        }
                        break;
                    }
                    case 'L': {
                        if (--x == -1) {
                            break loop;
                        }
                        break;
                    }
                    case 'U': {
                        if (--y == -1) {
                            break loop;
                        }
                        break;
                    }
                    case 'D': {
                        if (++y == n) {
                            break loop;
                        }
                        break;
                    }
                }
                count++;
            }
            answer[start] = count;
        }
        return answer;

    }
}
