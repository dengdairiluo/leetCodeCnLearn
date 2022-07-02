package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-02 23:08
 */
public class Q833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        List<String> list = new ArrayList<>();
        // 记录当前起始位置
        int start = 0;
        Arrays.sort(indexes);
        for (int i = 0; i < indexes.length; i++) {
            String source = map.get(indexes[i])[0];
            String target = map.get(indexes[i])[1];
            // 从indexes[i]查找
            int index = S.indexOf(source, indexes[i]);
            // 必须等于indexed[i]，否则可能在后面的位置找到source
            if (index == indexes[i]) {
                list.add(S.substring(start, index));
                list.add(target);
                // 更新start位置
                start = index + source.length();
            }
        }
        list.add(S.substring(start));
        // 使用StringBuilder更快
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
