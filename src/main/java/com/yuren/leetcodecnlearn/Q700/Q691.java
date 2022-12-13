package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-02 23:11
 */
public class Q691 {
    int res;

    public int minStickers(String[] stickers, String t) {
        //判断所有字母是否都存在
        Set<Integer> set = new HashSet<>();

        // 目标node
        Node target = new Node(t, set);

        // stickers
        List<Node> list = new ArrayList<>();

        for (String sticker : stickers) {
            Node node = new Node(sticker, target.memo, set);
            // 权值大于0
            if (node.weight > 0) {
                boolean needAdd = true;
                for (int i = list.size() - 1; i >= 0; i--) {
                    Node p = list.get(i);
                    int r = contains(node, p);
                    if (r == 1) {
                        // node包含p, 将p删除
                        needAdd = true;
                        list.remove(i);
                    } else if (r == -1) {
                        // p包含node, node不再加入到list内
                        needAdd = false;
                        break;
                    }
                }
                if (needAdd) {
                    list.add(node);
                }
            }
        }

        //判断是否所有字母都在stickers中出现
        if (!set.isEmpty()) {
            return -1;
        }

        // 按照权值排序, 权值大的放前面
        list.sort((x, y) -> y.weight - x.weight);

        // 由于所有字母都存在, 最坏情况 res=target的长度 - 最大的权值 + 1
        res = t.length() - list.get(0).weight + 1;

        dfs(list, target, 0, 0);

        return res;
    }


    public void dfs(List<Node> list, Node target, int p, int count) {
        // 当结果大于等于res, 本次结果舍弃
        if (count >= res) {
            return;
        }

        // 判断当前target是否全部小于0, 全部小于0说明所有字母已经存在
        boolean isZero = true;
        for (int i : target.memo) {
            if (i > 0) {
                isZero = false;
                break;
            }
        }
        if (isZero) {
            res = Math.min(res, count);
        }

        for (int i = p; i < list.size(); i++) {
            Node node = list.get(i);

            // 判断node中是否有taget需要的字母
            boolean contains = false;
            for (int j = 0; j < 26; j++) {
                if (node.memo[j] > 0 && target.memo[j] > 0) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                continue;
            }

            // 回溯法
            // target 减去 node 的数量
            for (int j = 0; j < 26; j++) {
                target.memo[j] -= node.memo[j];
            }
            dfs(list, target, i, count + 1);
            for (int j = 0; j < 26; j++) {
                target.memo[j] += node.memo[j];
            }
        }
    }

    private int contains(Node m, Node n) {
        //m 是否包含 n
        boolean mMax = true;
        //n 是否包含 m
        boolean nMax = true;
        for (int i = 0; i < 26 && (mMax || nMax); i++) {
            if (m.memo[i] > n.memo[i]) {
                nMax = false;
            } else if (m.memo[i] < n.memo[i]) {
                mMax = false;
            }
        }
        if (mMax) {
            return 1;
        }
        if (nMax) {
            return -1;
        }
        return 0;
    }

    private static class Node {
        int[] memo;
        int weight;

        public Node(String str, int[] target, Set<Integer> set) {
            memo = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (target[idx] > 0) {
                    memo[idx]++;
                }
            }
            for (int i = 0; i < memo.length; i++) {
                if (memo[i] > 0) {
                    weight += Math.min(memo[i], target[i]);
                    set.remove(i);
                }
            }
        }

        public Node(String str, Set<Integer> set) {
            memo = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                memo[idx]++;
                set.add(idx);
            }
        }
    }
}
