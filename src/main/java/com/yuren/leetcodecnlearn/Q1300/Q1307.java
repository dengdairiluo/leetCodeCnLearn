package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-20 23:45
 */
public class Q1307 {
    /**
     * char to num
     */
    int[] c2N = new int[26];
    /**
     * num to char
     */
    int[] n2C = new int[10];
    /**
     * 不为0的字母
     */
    boolean[] not0 = new boolean[26];

    public boolean isSolvable(String[] words, String result) {
        int maxWord = 1;
        for (String word : words) {
            //记录不能为前导零的字母
            if (word.length() > 1) {
                not0[word.charAt(0) - 'A'] = true;
            }
            maxWord = Math.max(maxWord, word.length());
            //如果存在word长度大于result长度，无解
            if (word.length() > result.length()) {
                return false;
            }
        }
        //最大word长度+1小于result长度，无解
        if (maxWord + 1 < result.length()) {
            return false;
        }
        //记录不能为前导零的字母
        if (result.length() > 1) {
            not0[result.charAt(0) - 'A'] = true;
        }
        Arrays.fill(c2N, -1);
        Arrays.fill(n2C, -1);
        return dfs(words, result, 0, 0, 0);
    }

    public boolean dfs(String[] words, String result, int wordIdx, int pos, int x) { //wordIdx为当前遍历到的word索引，pos为已经校验和的倒数索引， x为进位
        //遍历到result第一位之前，若进位为0，恰好找到解
        if (pos == result.length()) {
            return x == 0;
        }

        //遍历完一轮words，
        if (wordIdx == words.length) {
            //所有word倒数pos位置的数字和
            int sum = x;
            for (String word : words) {
                //如果word长度不足则直接跳过
                if (word.length() > pos) {
                    sum += c2N[word.charAt(word.length() - 1 - pos) - 'A'];
                }
            }
            int num = sum % 10;
            char c = result.charAt(result.length() - 1 - pos);
            //result倒数pos位置的字母已经有映射，则必须等于num
            if (c2N[c - 'A'] != -1) {
                if (c2N[c - 'A'] == num) {
                    //wordidx回到0， pos向前进一个，进位更新为sum / 10
                    return dfs(words, result, 0, pos + 1, sum / 10);
                }
                return false;
            } else {
                //如果num已经被其他字母映射，无解
                if (n2C[num] != -1) {
                    return false;
                }
                //result倒数pos位置的字母映射为num
                c2N[c - 'A'] = num;
                n2C[num] = (int) c;
                boolean check = dfs(words, result, 0, pos + 1, sum / 10);
                if (check) {
                    return true;
                }
                n2C[num] = -1;
                c2N[c - 'A'] = -1;
                return false;
            }
        } else { //在某一轮words的遍历中
            String word = words[wordIdx];
            //当前word长度不足，wordidx向前进一个
            if (word.length() <= pos) {
                return dfs(words, result, wordIdx + 1, pos, x);
            } else {
                char c = word.charAt(word.length() - 1 - pos);
                //word在倒数pos位置已经有映射
                if (c2N[c - 'A'] != -1) {
                    return dfs(words, result, wordIdx + 1, pos, x);
                } else {
                    //如果该位置字母不能为0，尝试在1~9中为其分配
                    if (not0[c - 'A']) {
                        for (int i = 1; i < 10; i++) {
                            if (n2C[i] == -1) {
                                n2C[i] = c;
                                c2N[c - 'A'] = i;
                                //wordIdx向前进一个，pos不变
                                boolean check = dfs(words, result, wordIdx + 1, pos, x);
                                if (check) {
                                    return true;
                                }
                                c2N[c - 'A'] = -1;
                                n2C[i] = -1;
                            }
                        }
                    } else {
                        //在0-9中为其分配
                        for (int i = 0; i < 10; i++) {
                            if (n2C[i] == -1) {
                                n2C[i] = c;
                                c2N[c - 'A'] = i;
                                boolean check = dfs(words, result, wordIdx + 1, pos, x);
                                if (check) {
                                    return true;
                                }
                                c2N[c - 'A'] = -1;
                                n2C[i] = -1;
                            }
                        }
                    }
                }
            }
        }
        //所有方案都不满足
        return false;
    }
}
