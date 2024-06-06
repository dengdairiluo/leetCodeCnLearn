package com.yuren.leetcodecnlearn.Q2400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-05 下午11:58
 */
public class Q2456 {
    //字典序最小的 id,ids里面不是排序的，不能直接遍历取 要遍历再判断。
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        //把创作者 和 该创作者的总播放量 当作 K和V 放进HashMap，顺便求个 最大的总播放量
        HashMap<String, Double> nameSumMap = new HashMap<>();
        HashMap<String, Integer> nameMaxViewMap = new HashMap<>();
        HashMap<String, String> nameIdMap = new HashMap<>();
        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            nameSumMap.put(creators[i], nameSumMap.getOrDefault(creators[i], 0.0) + views[i]);
            maxValue = Math.max(maxValue, nameSumMap.get(creators[i]));
            //当nameMaxViewMap为空时 或 遍历到更大的播放量的视频时 或 （遍历到播放量都是最大值的视频 且 该视频的id字典序更小时）
            // 把nameMaxViewMap、nameIdMap里该创作者的单个视频的最大播放量和对应的id 更新了
            // nameIdMap.get(creators[i]).compareTo(ids[i]) > 0 是 前一个的字典序 大于 后一个
            if (nameMaxViewMap.get(creators[i]) == null
                    || views[i] > nameMaxViewMap.get(creators[i])
                    || (views[i] == nameMaxViewMap.get(creators[i]) && nameIdMap.get(creators[i]).compareTo(ids[i]) > 0)) {
                nameMaxViewMap.put(creators[i], views[i]);
                nameIdMap.put(creators[i], ids[i]);
            }
        }
        //根据 最大的总播放量 求出该播放量的创作者们。
        List<List<String>> list = new ArrayList<>();
        for (String i : nameSumMap.keySet()) {
            if (nameSumMap.get(i).equals(maxValue)) {
                List<String> theOne = new ArrayList<>();
                theOne.add(i);
                theOne.add(nameIdMap.get(i));
                list.add(theOne);
            }
        }

        return list;
    }
}
