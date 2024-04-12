package com.yuren.leetcodecnlearn.Q800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-10 22:16
 */
public class Q850 {
    /**
     * [0,0,2,2],[1,0,2,3],[1,0,3,1]
     * [x,y,x,y]
     * 1.压缩横向坐标
     * 2.建立纵向线段
     * 3.从下向上，向线段树中添加线段，一层加完同上一层的层高差结算面积。
     * 每一层可能来自这一层的矩形下边，增加当前层长度，也可能来自之前矩形的上边，减少当前层长度。
     */
    public int rectangleArea(int[][] rectangles) {
        int mod = (int) 1e9 + 7;
        int len = rectangles.length;
        // 线段数据结构，延长线段，延长的长度取决于横向坐标差
        int add = 1;
        // 线段数据结构，缩短线段
        int sub = -1;
        // 横向线段数据结构：[线段高度,左端横坐标,右端横坐标,增/减]
        int[][] segment = new int[len << 1][4];
        // 线段数据结构，线段树索引
        int segmentIndex = 0;
        // 为压缩横向坐标数据，去掉重复的横坐标 && 从小到大排序
        TreeSet<Integer> unique = new TreeSet<>((a, b) -> a - b);
        // 完成横向压缩和纵向建立线段
        for (int i = 0; i < len; i++) {
            int[] cur = rectangles[i];
            // 横向压缩
            unique.add(cur[0]);
            // 横向压缩
            unique.add(cur[2]);
            // 纵向扫描
            segment[segmentIndex++] = new int[]{cur[1], cur[0], cur[2], add};
            // 纵向扫描
            segment[segmentIndex++] = new int[]{cur[3], cur[0], cur[2], sub};
        }
        // 从下到上依次排序
        Arrays.sort(segment, (a, b) -> a[0] == b[0] ? b[3] - a[3] : a[0] - b[0]);
        // 建立原坐标与压缩坐标索引
        Map<Integer, Integer> mapx = new HashMap<>();
        // 压缩坐标找原x坐标
        int[] compressX = new int[unique.size()];
        // 压缩坐标范围 && 编号
        int range = 0;
        for (Integer num : unique) {
            compressX[range] = num;
            mapx.put(num, range++);
        }
        long ans = 0;
        long lastY = 0;
        Node root = new Node(0, range - 1);
        int i = 0;
        while (i < segmentIndex) {
            int[] cur = segment[i];
            // [线段高度,左端横坐标,右端横坐标,增/减]
            long curY = cur[0];
            if (curY == lastY) {
                root.update(mapx.get(cur[1]), mapx.get(cur[2]), cur[3], compressX);
                i++;
            } else {
                long area = (curY - lastY) * root.segmentLength;
//				ans += area % MOD;
                ans = (ans + area) % mod;
                lastY = curY;
            }
        }
        return (int) ans;
    }

    private static class Node {
        private final int leftRange;
        private final int rightRange;
        private final int mid;
        private long segmentLength;
        private Node leftChild;
        private Node rightChild;
        private int level;// level==0 表示

        public Node(int left, int right) {
            this.leftRange = left;
            this.rightRange = right;
            this.mid = ((this.rightRange - this.leftRange) >> 1) + this.leftRange;
        }

        private Node leftNode() {
            if (this.leftChild == null) {
                this.leftChild = new Node(this.leftRange, this.mid);
            }
            return this.leftChild;
        }

        private Node rightNode() {
            if (this.rightChild == null) {
                this.rightChild = new Node(this.mid, this.rightRange);
            }
            return this.rightChild;
        }

        public void update(int left, int right, int update, int[] compressX) {
            // 必须有宽度，不能包含等于
            if (left >= right) {
                return;
            }
            if (left == this.leftRange && right == this.rightRange) {
                // 多个矩形边重合
                level += update;
                if (level == 1) {
                    this.segmentLength = compressX[right] - compressX[left];
                } else if (level == 0) {
                    // 这个地方一层没有，不一定是0啊，错这里了。只是[LeftRange,RightRange]连续的长度没了，但是不代表没有组合的长度
                    this.segmentLength = this.leftNode().segmentLength + this.rightNode().segmentLength;
                }
            } else {
                this.leftNode().update(left, Math.min(this.mid, right), update, compressX);
                this.rightNode().update(Math.max(this.mid, left), right, update, compressX);
                // 就丢了这一句话，这块不能无脑左右加的，因为父节点可能比子节点大，无脑加反而变小了
                if (level == 0) {
                    // 因为没有从父节点下发任务的过程
                    this.segmentLength = this.leftNode().segmentLength + this.rightNode().segmentLength;
                }

            }

        }
    }
}
