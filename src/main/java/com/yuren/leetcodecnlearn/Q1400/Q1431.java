package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.List;

public class Q1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (null == candies) {
            return new ArrayList<>();
        }

        int max = -1;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }

        List<Boolean> resp = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                resp.add(true);
            } else {
                resp.add(false);
            }
        }
        return resp;
    }
}
