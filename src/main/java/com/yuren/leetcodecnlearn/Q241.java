package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-16 22:22
 */
public class Q241 {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() <= 0) {
            return new ArrayList<>();
        }

        List<Integer> curRes = new ArrayList<>();
        int length = input.length();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < length; i++) {
            char aChar = charArray[i];
            if (aChar == '+' || aChar == '-' || aChar == '*') { // 当前字符为 操作符
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (aChar == '+') {
                            curRes.add(leftNum + rightNum);
                        } else if (aChar == '-') {
                            curRes.add(leftNum - rightNum);
                        } else {
                            curRes.add(leftNum * rightNum);
                        }
                    }
                }

            }
        }

        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(input));
        }
        return curRes;
    }
}
