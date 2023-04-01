package com.yuren.leetcodecnlearn.Q1500;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-02 03:18
 */
public class Q1500 {

    private int m;

    private int id = 1;

    private final Map<Integer, List<Integer>> users;

    private final PriorityQueue<Integer> gcQueue;

    private final Set<Integer>[] blocks;

    public Q1500(int m) {
        this.m = m;
        users = new HashMap<>();
        gcQueue = new PriorityQueue<>();
        blocks = new Set[m + 1];
    }

    public int join(List<Integer> ownedChunks) {
        int tmpId = -1;
        if (!gcQueue.isEmpty()) {
            tmpId = gcQueue.poll();
        } else {
            tmpId = id++;
        }
        users.put(tmpId, ownedChunks);
        for (int block : ownedChunks) {
            if (blocks[block] == null) {
                blocks[block] = new HashSet<>();
            }
            blocks[block].add(tmpId);
        }
        return tmpId;
    }

    public void leave(int userId) {
        List<Integer> owned = users.get(userId);
        for (int block : owned) {
            blocks[block].remove(userId);
        }
        users.remove(userId);
        gcQueue.offer(userId);
    }

    public List<Integer> request(int userId, int chunkId) {
        if (blocks[chunkId] == null) {
            blocks[chunkId] = new HashSet<>();
        }
        List<Integer> res = new ArrayList<>(blocks[chunkId]);
        if (!res.isEmpty()) {
            Collections.sort(res);
            users.get(userId).add(chunkId);
            blocks[chunkId].add(userId);
        }
        return res;
    }
}
