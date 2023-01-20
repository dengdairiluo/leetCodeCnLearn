package com.yuren.leetcodecnlearn.Q1400;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-20 23:49
 */
public class Q1311 {
    private static class VideoNode {
        private final String video;
        private final int times;

        public VideoNode(String video, int times) {
            this.video = video;
            this.times = times;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] flag = new boolean[102];
        flag[id] = true;

        Queue<Integer> queue = new LinkedList<>();
        for (int friend : friends[id]) {
            queue.offer(friend);
            flag[friend] = true;
        }
        int size = queue.size();
        while (--level > 0) {
            while (size > 0) {
                int node = queue.poll();
                size--;
                for (int friend : friends[node]) {
                    if (!flag[friend]) {
                        queue.offer(friend);
                        flag[friend] = true;
                    }
                }
            }
            size = queue.size();
        }
        List<VideoNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int f = queue.poll();
            for (String str : watchedVideos.get(f)) {
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    int ttt = map.get(str);
                    map.put(str, ttt + 1);
                }
            }
        }
        for (String str : map.keySet()) {
            VideoNode vn = new VideoNode(str, map.get(str));
            list.add(vn);
        }
        list.sort((o1, o2) -> {
            if (o1.times != o2.times) {
                return o1.times - o2.times;
            } else {
                return o1.video.compareTo(o2.video);
            }
        });
        List<String> res = new ArrayList<>();
        for (VideoNode vn : list) {
            res.add(vn.video);
        }
        return res;
    }
}
