package com.yuren.leetcodecnlearn.Q200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-27 23:36
 */
public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            //计算差值
            char[] chars = str.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                int diff = chars[i] - chars[i - 1] < 0 ? chars[i] - chars[i - 1] + 26 : chars[i] - chars[i - 1];
                sb.append(diff).append(",");
            }
            //如果只有一个元素，则将差值记为"*"
            String key = sb.toString().equals("") ? "*" : sb.substring(0, sb.length() - 1);
            //存入map
            List<String> list = map.get(key);
            if (list == null) list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
            sb.delete(0, sb.length());
        }

        return new ArrayList<>(map.values());
    }

}
