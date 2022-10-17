package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-17 23:44
 */
public class Q1087 {
    List<String> res;

    public String[] expand(String s) {
        if (!s.contains("{")) {
            return new String[]{s};
        }
        res = new ArrayList<>();
        backTrace(s, new StringBuilder(), 0);
        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    private void backTrace(String s, StringBuilder sb, int index) {

        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }
        //遇到’{‘字符
        if (s.charAt(index) == '{') {
            int count = 0;
            //先计算出{}中内容的长度count
            for (int j = index + 1; s.charAt(j) != '}'; j++) {
                count++;
            }
            //下次要跳转的位置就为index+count+2
            for (int j = index + 1; s.charAt(j) != '}'; j++) {
                char ch = s.charAt(j);
                if (ch != ',') {
                    sb.append(ch);
                    backTrace(s, sb, index + count + 2);
                    sb.deleteCharAt(sb.length() - 1);
                }

            }
        } else {//遇到其他字符
            sb.append(s.charAt(index));
            backTrace(s, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
