package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-25 22:48
 */
public class Q245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1, p2 = -1, n = wordsDict.length;
        int res = n;
        if (word1.equals(word2)) {
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (p1 != -1) {
                        res = Math.min(i - p1, res);
                    }
                    p1 = i;
                }
            }
        } else {
            for (int i = 0; i < wordsDict.length; i++) {
                // System.out.println(p1  + " " + p2);
                if (wordsDict[i].equals(word1)) {
                    if (p2 != -1) {
                        res = Math.min(i - p2, res);
                    }
                    p1 = i;
                }
                if (wordsDict[i].equals(word2)) {
                    if (p1 != -1) {
                        res = Math.min(i - p1, res);
                    }
                    p2 = i;
                }
            }
        }
        return res;
    }
}
