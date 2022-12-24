package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-22 23:28
 */
public class Q1167 {

    public int connectSticks(int[] sticks) {
        Heap4 q = new Heap4(sticks.length);

        for (int x : sticks) {
            q.push(x);
        }
        int sum = 0;
        while (q.size() > 1) {
            int temp = q.pop() + q.pop();
            sum += temp;
            q.push(temp);
        }
        return sum;
    }

    private static class Heap4 {
        private final int[] data;
        private int count = 0;

        public Heap4(int size) {
            data = new int[size];
        }

        public int size() {
            return count;
        }

        public void push(int n) {
            data[count++] = n;
            upward();
        }

        public int pop() {
            if (isEmpty()) {
                return 0;
            }
            int tmp = data[0];
            swap(0, count - 1);
            count--;
            downward();
            return tmp;
        }

        // 数据push，要向上移动保持大顶堆特性，小数要在根
        private void upward() {
            int idx = count - 1;
            while (idx > 0 && data[(idx - 1) / 2] > data[idx]) {
                // 父子交换
                swap((idx - 1) / 2, idx);
                idx = (idx - 1) / 2;
            }
        }

        // 数据pop，要向下调整保持大顶堆特性，小数要在根
        private void downward() {
            int idx = 0;
            // 左节点数据超过count，说明没有左节点了
            while (idx * 2 + 1 < count) {
                int tmp = idx;
                // 父节点 vs 左子
                if (data[tmp] > data[idx * 2 + 1]) {
                    idx = idx * 2 + 1;
                }
                // idx * 2 + 2 判断是否有右节点
                // data[idx] < data[tmp * 2 + 2] 左子 vs 右子
                if (tmp * 2 + 2 < count && data[idx] > data[tmp * 2 + 2]) {
                    idx = tmp * 2 + 2;
                }
                if (tmp == idx) {
                    break;
                }
                swap(tmp, idx);
            }
        }

        private void swap(int i1, int i2) {
            int tmp = data[i1];
            data[i1] = data[i2];
            data[i2] = tmp;
        }

        public boolean isEmpty() {
            return count == 0;
        }
    }
}
