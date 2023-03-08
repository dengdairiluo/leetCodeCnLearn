package com.yuren.leetcodecnlearn.Q1300;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-06 23:47
 */
public class Q1348 {
    private final HashMap<String, TreeMap<Integer, Integer>> mapping = new HashMap<>();

    public Q1348() {

    }

    public void recordTweet(String tweetName, int time) {
        if (!mapping.containsKey(tweetName)) {
            mapping.put(tweetName, new TreeMap<Integer, Integer>());
        }
        mapping.get(tweetName).put(time, mapping.get(tweetName).getOrDefault(time, 0) + 1);
    }


    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans = new ArrayList<>();
        int gap;
        if (freq.equals("minute")) {
            gap = 60;
        } else if (freq.equals("hour")) {
            gap = 60 * 60;
        } else { // day
            gap = 60 * 60 * 24;
        }

        int cur = startTime;
        while (cur <= endTime) {
            ans.add(0);
            cur += gap;
        }
        SortedMap<Integer, Integer> tailMap = mapping.get(tweetName).subMap(startTime, endTime + 1);
        for (Map.Entry<Integer, Integer> entry : tailMap.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            ans.set((key - startTime) / gap, ans.get((key - startTime) / gap) + val);
        }
        return ans;
    }
}
