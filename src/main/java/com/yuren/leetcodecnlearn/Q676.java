package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-25 07:06
 */
public class Q676 {
    Map<Integer, List<String>> map;

    public Q676() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String dic : dictionary) {
            int len = dic.length();
            if (!map.containsKey(len)) map.put(len, new ArrayList<>());
            map.get(len).add(dic);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        //符合条件的必定是和要验证的字符串的长度相等的
        if (!map.containsKey(len)) return false;
        for (String dic : map.get(len)) {
            //修改次数
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (dic.charAt(i) != searchWord.charAt(i)) cnt++;
                if (cnt > 1) break;
            }
            //说明可以只修改一个字母,就使得所形成的新字符串能够与字典中的任一字符串匹配
            if (cnt == 1) return true;
        }
        return false;
    }
}
