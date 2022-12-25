package com.yuren.leetcodecnlearn.Q1300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-26 06:06
 */
public class Q1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        //使用双指针查找相应的数
        int left = 1;
        int right = z;
        while (left <= z && right > 0) {
            int sum = customfunction.f(left, right);
            if (sum == z) {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
                left++;
                right--;
            } else if (sum < z) {
                left++;
            } else {
                right--;
            }

        }
        return res;

    }

    private static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    }
}
