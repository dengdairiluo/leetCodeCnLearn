package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-22 22:40
 */
public class Q737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        //每个字符与一个整数进行映射，这个整数标识唯一标识这个字符串
        if (sentence1.length != sentence2.length) return false;
        int n = similarPairs.size();
        Map<String, Integer> map = new HashMap<>();
        DiffSet set = new DiffSet(2 * n);//
        int index = 0;
        for (List<String> list : similarPairs) {
            for (String s : list) {
                if (!map.containsKey(s))
                    map.put(s, index++);
            }
        }
        //
        for (List<String> list : similarPairs) {
            String s1 = list.get(0);
            String s2 = list.get(1);
            set.union(map.get(s1), map.get(s2));
        }
        //
        for (int i = 0; i < sentence1.length; i++) {
            String x = sentence1[i];
            String y = sentence2[i];
            if (x.equals(y)) continue;
            if (!map.containsKey(x) || !map.containsKey(y)) return false;
            if (!set.cp(map.get(x), map.get(y))) return false;
        }
        return true;
    }

    static public class DiffSet {
        int[] parent;

        public DiffSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public boolean cp(int index1, int index2) {
            return find(index1) == find(index2);
        }

        public int getNum() {
            int res = 0;
            for (int i = 0; i < parent.length; i++) if (parent[i] == i) res++;
            return res;
        }

        public void union(int index1, int index2) {
            parent[find(index1)] = find(index2);
        }

        public int find(int index) {
            while (parent[index] != index) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }
    }
}
