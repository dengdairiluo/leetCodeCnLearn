package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-14 23:46
 */
public class Q1598 {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            switch (log) {
                case "./":
                    continue;
                case "../":
                    if (depth > 0) {
                        depth--;
                    }
                    break;
                default:
                    depth++;
                    break;
            }
        }
        return depth;
    }
}
