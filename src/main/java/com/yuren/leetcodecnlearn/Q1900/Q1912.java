package com.yuren.leetcodecnlearn.Q1900;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-08 23:30
 */
public class Q1912 {
    static final int TOP_SIZE = 5;
    static Comparator<ShopMovie> MOVIE_COMPARATOR = (o1, o2) -> {
        if (o1.price != o2.price) {
            return o1.price < o2.price ? -1 : 1;
        }
        if (o1.shopId != o2.shopId) {
            return o1.shopId < o2.shopId ? -1 : 1;
        }
        return Integer.compare(o1.movieId, o2.movieId);
    };
    private final Map<Integer, TopQueue<ShopMovie>> movieIdToTopQueue;
    private final Map<ShopMovieKey, ShopMovie> keyToShopMovie;
    private final TopQueue<ShopMovie> rentedTopQueue;

    public Q1912(int n, int[][] entries) {

        movieIdToTopQueue = new HashMap<>();

        keyToShopMovie = new HashMap<>();

        for (int[] entry : entries) {
            int shopId = entry[0];
            int movieId = entry[1];
            int price = entry[2];
            ShopMovie shopMovie = new ShopMovie(shopId, movieId, price);
            TopQueue<ShopMovie> topQueue = movieIdToTopQueue.computeIfAbsent(movieId, (k) -> new TopQueue<>(TOP_SIZE, MOVIE_COMPARATOR));
            topQueue.add(shopMovie);

            keyToShopMovie.put(new ShopMovieKey(shopId, movieId), shopMovie);
        }

        rentedTopQueue = new TopQueue<>(TOP_SIZE, MOVIE_COMPARATOR);
    }

    public List<Integer> search(int movieId) {

        TopQueue<ShopMovie> topQueue = movieIdToTopQueue.get(movieId);

        if (topQueue == null) {
            return new ArrayList<>();
        }

        List<Integer> shopIdList = new ArrayList<>(topQueue.list.size());
        for (ShopMovie shopMovie : topQueue.list) {
            shopIdList.add(shopMovie.shopId);
        }

        return shopIdList;
    }

    public void rent(int shopId, int movieId) {

        ShopMovie shopMovie = keyToShopMovie.get(new ShopMovieKey(shopId, movieId));

        TopQueue<ShopMovie> unRentedTopQueue = movieIdToTopQueue.get(movieId);
        unRentedTopQueue.remove(shopMovie);

        rentedTopQueue.add(shopMovie);
    }

    public void drop(int shopId, int movieId) {

        ShopMovie shopMovie = keyToShopMovie.get(new ShopMovieKey(shopId, movieId));

        rentedTopQueue.remove(shopMovie);

        TopQueue<ShopMovie> unRentedTopQueue = movieIdToTopQueue.get(movieId);
        unRentedTopQueue.add(shopMovie);
    }

    public List<List<Integer>> report() {

        List<List<Integer>> shopMovieList = new ArrayList<>(rentedTopQueue.list.size());
        for (ShopMovie shopMovie : rentedTopQueue.list) {
            List<Integer> pair = new ArrayList<>(2);
            pair.add(shopMovie.shopId);
            pair.add(shopMovie.movieId);
            shopMovieList.add(pair);
        }

        return shopMovieList;
    }

    static class TopQueue<T> {

        private int k;

        private Comparator<T> comparator;

        private List<T> list;

        private Queue<T> minQueue;

        private Queue<T> minDeleteQueue;

        TopQueue(int k, Comparator<T> comparator) {
            this.k = k;
            this.comparator = comparator;
            this.list = new ArrayList<>(k);
            this.minQueue = new PriorityQueue<>(comparator);
            this.minDeleteQueue = new PriorityQueue<>(comparator);
        }

        private int findIndex(T obj) {
            int i = list.size() - 1;
            for (; i >= 0; i--) {
                if (comparator.compare(obj, list.get(i)) > 0) {
                    break;
                }
            }
            return i + 1;
        }

        public void add(T obj) {
            if (list.size() < k) {
                int index = findIndex(obj);
                list.add(index, obj);
            } else {
                T last = list.get(list.size() - 1);
                if (comparator.compare(obj, last) < 0) {
                    list.remove(list.size() - 1);
                    minQueue.add(last);
                    int index = findIndex(obj);
                    list.add(index, obj);
                } else {
                    minQueue.add(obj);
                }
            }
        }

        public void remove(T obj) {
            int index = findIndex(obj);
            if (index == list.size()) {
                minDeleteQueue.add(obj);
            } else {
                T removeObj = list.get(index);
                if (comparator.compare(obj, removeObj) != 0) {
                    throw new IllegalStateException();
                }
                list.remove(index);
                for (T minObj; (minObj = minQueue.poll()) != null; ) {
                    T delObj = minDeleteQueue.peek();
                    int cmp;
                    if (delObj != null && (cmp = comparator.compare(minObj, delObj)) >= 0) {
                        if (cmp > 0) {
                            throw new IllegalStateException();
                        }
                        minDeleteQueue.poll();
                    } else {
                        list.add(minObj);
                        break;
                    }
                }
            }
        }
    }

    static class ShopMovieKey {

        int shopId;
        int movieId;

        public ShopMovieKey(int shopId, int movieId) {
            this.shopId = shopId;
            this.movieId = movieId;
        }

        @Override
        public boolean equals(Object o) {
            ShopMovieKey that = (ShopMovieKey) o;
            return shopId == that.shopId && movieId == that.movieId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shopId, movieId);
        }
    }

    static class ShopMovie {
        int shopId;
        int movieId;
        int price;

        public ShopMovie(int shopId, int movieId, int price) {
            this.shopId = shopId;
            this.movieId = movieId;
            this.price = price;
        }
    }
}
