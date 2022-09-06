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
 * @date 2022-09-06 23:50
 */
public class Q981 {
    private static class Node {
        String k;
        String v;
        int t;

        Node(String k, String v, int t) {
            this.k = k;
            this.v = v;
            this.t = t;
        }
    }

    Map<String, List<Node>> map = new HashMap<>();

    public void set(String k, String v, int t) {
        List<Node> list = map.getOrDefault(k, new ArrayList<>());
        list.add(new Node(k, v, t));
        map.put(k, list);
    }

    public String get(String k, int t) {
        List<Node> list = map.getOrDefault(k, new ArrayList<>());
        if (list.isEmpty()) {
            return "";
        }
        int n = list.size();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid).t <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return list.get(r).t <= t ? list.get(r).v : "";
    }
}
