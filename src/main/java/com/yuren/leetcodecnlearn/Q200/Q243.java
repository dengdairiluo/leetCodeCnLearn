package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-24 23:15
 */
public class Q243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = words.length;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                // 如果当前的位置为word1,更新word1的位置
                index1 = i;
                if (index2 >= 0) {
                    // 计算距离
                    result = Math.min(index1 - index2, result);
                }
            } else if (words[i].equals(word2)) {
                // 如果当前的位置为word2, 更新word2的位置
                index2 = i;
                if (index1 >= 0) {
                    // 计算距离
                    result = Math.min(index2 - index1, result);
                }
            }
        }
        return result;
    }
}
