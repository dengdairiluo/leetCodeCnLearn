package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-29 下午11:38
 */
public class Q2506 {
    public int similarPairs(String[] words) {
        int len = words.length;
        // 对每个字符串提取特征
        int[] wordFeature = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                // 特征值使用int型32位，存储26字母各位，根据字母表索引对应位置1
                wordFeature[i] = wordFeature[i] | (1 << (c - 'a'));
            }
        }

        // 两两比较特征值是否相等并统计
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (wordFeature[i] == wordFeature[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
