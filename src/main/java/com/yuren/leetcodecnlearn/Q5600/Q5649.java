package com.yuren.leetcodecnlearn.Q5600;

public class Q5649 {
    public int[] decode(int[] encoded, int first) {
        int[] resp = new int[encoded.length + 1];
        resp[0] = first;
        for (int i = 1; i < resp.length; i++) {
            resp[i] = resp[i - 1] ^ encoded[i - 1];
        }
        return resp;
    }

}
