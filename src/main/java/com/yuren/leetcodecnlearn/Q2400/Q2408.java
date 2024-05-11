package com.yuren.leetcodecnlearn.Q2400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-11 下午11:37
 */
public class Q2408 {
    HashMap<String, List<List<String>>> map = new HashMap<>();

    public Q2408(List<String> names, List<Integer> columns) {
        for (String s : names) {
            map.put(s, new ArrayList<>());
        }
    }

    public void insertRow(String name, List<String> row) {
        map.get(name).add(row);
    }

    public void deleteRow(String name, int rowId) {
        map.get(name).get(rowId - 1).clear();
    }

    public String selectCell(String name, int rowId, int columnId) {
        return map.get(name).get(rowId - 1).get(columnId - 1);
    }
}
