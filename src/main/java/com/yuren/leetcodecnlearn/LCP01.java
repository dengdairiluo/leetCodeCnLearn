package com.yuren.leetcodecnlearn;

public class LCP01 {
    public int game(int[] guess, int[] answer) {
        int t1 = guess[0] == answer[0] ? 1 : 0;
        int t2 = guess[1] == answer[1] ? 1 : 0;
        int t3 = guess[2] == answer[2] ? 1 : 0;
        return t1 + t2 + t3;
    }
}
