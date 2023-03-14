package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-14 22:59
 */
public class Q1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<String, BitSet> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> list = favoriteCompanies.get(i);
            for (String com : list) {
                BitSet set = map.getOrDefault(com, new BitSet(100));
                set.set(i);
                map.putIfAbsent(com, set);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> list = favoriteCompanies.get(i);
            BitSet bs = new BitSet();
            for (int j = 0; j < list.size(); j++) {
                BitSet set = map.get(list.get(j));
                if (j == 0) {
                    bs.or(set);
                } else {
                    bs.and(set);
                }
                if (bs.cardinality() == 1) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;

    }
}
