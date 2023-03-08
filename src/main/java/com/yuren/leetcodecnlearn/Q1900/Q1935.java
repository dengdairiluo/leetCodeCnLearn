package com.yuren.leetcodecnlearn.Q1900;

public class Q1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] strs = text.split(" ");
        int res = 0; //结果
        for (String str : strs) {  //遍历每一个单词
            boolean flag = true; //flag记录
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (str.indexOf(brokenLetters.charAt(j)) >= 0) { //如果包括，就跳出
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += 1;
            }
        }
        return res;
    }
}
