package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-25 07:10
 */
public class Q677 {
    Map<String,Integer> map;

    public Q677() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for(String s: map.keySet()){
            if(s.startsWith(prefix)){
                ans += map.get(s);
            }
        }
        return ans;
    }
}
