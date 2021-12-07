package com.yuren.leetcodecnlearn;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-07 23:32
 */
public class Q355 {

    /**
     * 所有用户的推文
     */
    List<Post> allPost;
    /**
     * userId -> 关注的用户Id
     */
    Map<Integer, Set<Integer>> map;

    public Q355() {
        allPost = new ArrayList<>();
        map = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Set<Integer> set = map.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        map.put(userId, set);

        allPost.add(0, new Post(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> set = map.get(userId);
        List<Integer> ans = new ArrayList<>();

        for (Post post : allPost) {
            if (set.contains(post.userId)) {
                ans.add(post.tweetId);
            }

            if (ans.size() == 10) {
                break;
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set1 = map.getOrDefault(followerId, new HashSet<>());
        set1.add(followeeId);
        map.put(followerId, set1);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set1 = map.getOrDefault(followerId, new HashSet<>());
        set1.remove(followeeId);
        map.put(followerId, set1);
    }

    private static class Post {
        int userId;
        int tweetId;

        Post(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
}
