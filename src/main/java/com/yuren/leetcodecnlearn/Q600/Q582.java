package com.yuren.leetcodecnlearn.Q600;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-16 23:31
 */
public class Q582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int r = queue.remove();
            l.add(r);
            if (map.containsKey(r)) {
                queue.addAll(map.get(r));
            }
        }
        return l;
    }
}
