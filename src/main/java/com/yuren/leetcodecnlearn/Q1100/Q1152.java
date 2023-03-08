package com.yuren.leetcodecnlearn.Q1100;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-15 23:47
 */
public class Q1152 {
    private static class Visit {
        String user;
        int time;
        String web;

        public Visit(String user, int time, String web) {
            this.user = user;
            this.time = time;
            this.web = web;
        }
    }

    private static class IPattern {
        String w1;
        String w2;
        String w3;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            IPattern iPattern = (IPattern) o;
            return Objects.equals(w1, iPattern.w1) && Objects.equals(w2, iPattern.w2) && Objects.equals(w3, iPattern.w3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(w1, w2, w3);
        }

        public IPattern(String w1, String w2, String w3) {
            this.w1 = w1;
            this.w2 = w2;
            this.w3 = w3;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Set<Visit> set = new HashSet<>();
        for (int i = 0; i < username.length; i++) {
            set.add(new Visit(username[i], timestamp[i], website[i]));
        }
        Map<String, List<Visit>> map = new HashMap<>();
        for (Visit v : set) {
            if (!map.containsKey(v.user)) {
                map.put(v.user, new ArrayList<>());
            }
            map.get(v.user).add(v);
        }
        Map<IPattern, Set<String>> map1 = new HashMap<>();
        for (Map.Entry<String, List<Visit>> entry : map.entrySet()) {
            if (entry.getValue().size() > 2) {
                record(entry.getValue(), map1, entry.getKey());
            }
        }
        Comparator<IPattern> iPatternComparator = (o1, o2) -> {
            if (o1.w1.equals(o2.w1)) {
                if (o1.w2.equals(o2.w2)) {
                    return o1.w3.compareTo(o2.w3);
                } else {
                    return o1.w2.compareTo(o2.w2);
                }
            } else {
                return o1.w1.compareTo(o2.w1);
            }
        };
        int max = 0;
        IPattern res = null;
        for (Map.Entry<IPattern, Set<String>> entry : map1.entrySet()) {
            if (entry.getValue().size() == max) {
                if (iPatternComparator.compare(res, entry.getKey()) > 0) {
                    res = entry.getKey();
                }
            } else if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                res = entry.getKey();
            }
        }
        IPattern iPattern = res;
        return Arrays.asList(iPattern.w1, iPattern.w2, iPattern.w3);
    }

    private void record(List<Visit> v, Map<IPattern, Set<String>> map1, String key) {
        v.sort(Comparator.comparingInt(o -> o.time));
        String[] temp = new String[v.size()];
        int i = 0;
        for (Visit visit : v) {
            temp[i++] = visit.web;
        }
        String[] template = new String[3];
        dfs(temp, 0, map1, template, 0, key);
    }

    private void dfs(String[] temp, int t, Map<IPattern, Set<String>> map1, String[] template, int level, String key) {
        if (level == 3) {
            IPattern iPattern = new IPattern(template[0], template[1], template[2]);
            if (!map1.containsKey(iPattern)) {
                map1.put(iPattern, new HashSet<>());
            }
            map1.get(iPattern).add(key);
            return;
        }
        for (int i = t; i < temp.length; i++) {
            template[level] = temp[i];
            dfs(temp, i + 1, map1, template, level + 1, key);
        }
    }
}
