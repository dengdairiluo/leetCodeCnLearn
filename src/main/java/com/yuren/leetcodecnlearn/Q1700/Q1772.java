package com.yuren.leetcodecnlearn.Q1700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-16 23:26
 */
public class Q1772 {
    private static class FeatureInfo {
        public String feature;

        public int sum;

        public int tag;

        public FeatureInfo(String feature, int sum, int tag) {
            this.feature = feature;
            this.sum = sum;
            this.tag = tag;
        }
    }


    public String[] sortFeatures(String[] features, String[] responses) {
        Set<String> featureSet = new HashSet<>(Arrays.asList(features));

        Map<String, Integer> featureNums = new HashMap<>();
        for (String line : responses) {
            Set<String> nowLineSet = new HashSet<>();
            for (String word : line.split(" ")) {
                if (featureSet.contains(word)) {
                    nowLineSet.add(word);
                }
            }
            nowLineSet.forEach(p -> {
                featureNums.putIfAbsent(p, 0);
                featureNums.put(p, featureNums.get(p) + 1);
            });
        }

        List<FeatureInfo> featureInfoList = new ArrayList<>();
        for (int i = 0; i < features.length; i++) {
            featureInfoList.add(new FeatureInfo(features[i], featureNums.getOrDefault(features[i], 0), i));
        }
        featureInfoList.sort((o1, o2) -> {
            if (o1.sum == o2.sum) {
                return o1.tag - o2.tag;
            }
            return o2.sum - o1.sum;
        });
        String[] result = new String[featureInfoList.size()];
        for (int i = 0; i < featureInfoList.size(); i++) {
            result[i] = featureInfoList.get(i).feature;
        }
        return result;
    }
}
