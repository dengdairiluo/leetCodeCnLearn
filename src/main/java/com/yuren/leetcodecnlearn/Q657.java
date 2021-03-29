package com.yuren.leetcodecnlearn;

public class Q657 {
    public boolean judgeCircle(String moves) {

        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                x--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'U') {
                y++;
            } else if ( c== 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
