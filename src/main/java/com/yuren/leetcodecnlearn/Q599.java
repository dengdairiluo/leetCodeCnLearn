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
 * @date 2022-03-22 23:30
 */
public class Q599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 只需要加这三行代码
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }

        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int cur = i + map1.get(list2[i]);
                if (cur == min) {
                    list.add(list2[i]);
                } else if (cur < min) {
                    min = cur;
                    list.clear();
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
