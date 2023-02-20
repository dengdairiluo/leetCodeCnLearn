package com.yuren.leetcodecnlearn.Q1400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-20 23:49
 */
public class Q1396 {
    Map<String, Map<String, long[]>> map = new HashMap<>();
    Map<Integer, Object[]> position = new HashMap<>();

    public Q1396() {

    }

    public void checkIn(int id, String stationName, int t) {
        position.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] objects = position.remove(id);
        long cost = t - (Integer) objects[1];
        Map<String, long[]> map1 = map.computeIfAbsent(objects[0].toString(), k -> new HashMap<>());
        long[] arr = map1.computeIfAbsent(stationName, l -> new long[2]);
        arr[0] += cost;
        arr[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        long[] arr = map.get(startStation).get(endStation);
        return (double) arr[0] / arr[1];
    }
}
