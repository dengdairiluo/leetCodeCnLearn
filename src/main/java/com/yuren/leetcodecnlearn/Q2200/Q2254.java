package com.yuren.leetcodecnlearn.Q2200;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-23 21:40
 */
public class Q2254 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    HashMap<Integer, Video> map = new HashMap<>();


    public Q2254() {

    }

    public int upload(String video) {
        if (pq.isEmpty()) {
            pq.add(map.size());
        }
        int index = pq.poll();
        map.put(index, new Video(video));
        return index;
    }

    public void remove(int videoId) {
        if (map.containsKey(videoId)) {
            map.remove(videoId);
            pq.add(videoId);
        }

    }

    public String watch(int videoId, int startMinute, int endMinute) {
        if (map.containsKey(videoId)) {
            map.get(videoId).watchNum++;
            return map.get(videoId).name.substring(startMinute, Math.min(endMinute + 1, map.get(videoId).name.length()));
        }
        return "-1";
    }

    public void like(int videoId) {
        if (map.containsKey(videoId)) {
            map.get(videoId).like += 1;
        }
    }

    public void dislike(int videoId) {
        if (map.containsKey(videoId)) {
            map.get(videoId).dislike += 1;
        }

    }

    public int[] getLikesAndDislikes(int videoId) {
        if (map.containsKey(videoId)) {
            return new int[]{map.get(videoId).like, map.get(videoId).dislike};
        }
        return new int[]{-1};
    }

    public int getViews(int videoId) {
        if (map.containsKey(videoId)) {
            return map.get(videoId).watchNum;
        }
        return -1;
    }

    private static class Video {
        public String name;
        public int id = 0;
        public int like = 0;
        public int dislike = 0;
        public int watchNum = 0;

        Video(String name) {
            this.name = name;
        }
    }
}
