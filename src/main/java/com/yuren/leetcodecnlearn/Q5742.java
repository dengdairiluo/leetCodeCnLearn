package com.yuren.leetcodecnlearn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-17 06:29
 */
public class Q5742 {
    public String sortSentence1(String s) {
        // 先切分字符串
        String[] strings = s.split(" ");
        // 对每一个字符串的最后一个字符进行递增排序
        Arrays.sort(strings, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));
        StringBuilder builder = new StringBuilder();
        // 拼接字符串，记得删掉末尾的数字
        for (String ss : strings) {
            builder.append(ss, 0, ss.length() - 1).append(" ");
        }
        // 删掉末尾多余的空格再返回
        return builder.substring(0, builder.length() - 1);
    }

    public String sortSentence2(String s) {
        // 先切分字符串
        String[] strings = s.split(" ");
        // 对每一个字符串的最后一个字符进行递增排序
        Arrays.sort(strings, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));
        StringBuilder builder = new StringBuilder();
        // 拼接字符串，记得删掉末尾的数字
        for (String ss : strings) {
            builder.append(ss, 0, ss.length() - 1).append(" ");
        }
        // 删掉末尾多余的空格再返回
        return builder.substring(0, builder.length() - 1);

    }
}
