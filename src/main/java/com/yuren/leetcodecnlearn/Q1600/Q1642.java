package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-28 23:48
 */
public class Q1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Use PriorityQueue if you don't want to implement a Heap
        // reuse heights to save some memory
        Heap heap = new Heap(heights);

        int n = heights.length, i = 0;

        // use up all ladders first
        for (; i < n - 1; i++) {
            int delta = heights[i + 1] - heights[i];
            if (delta <= 0) {
                continue;
            }
            if (ladders == 0) {
                break;
            }

            // record the bricks saved in each step
            heap.push(delta);
            ladders--;
        }

        // use bricks
        for (; i < n - 1; i++) {
            int delta = heights[i + 1] - heights[i];
            if (delta <= 0) {
                continue;
            }

            // use min bricks (try to replace a prior ladder if it consumes fewer bricks)
            bricks -= heap.replace(delta);
            if (bricks < 0) {
                return i;
            }
        }
        return n - 1;
    }

    /**
     * Minimum heap
     */
    private static class Heap {
        private final int[] heap;
        private int size = 0;

        public Heap(int n) {
            this.heap = new int[n];
        }

        public Heap(int[] arr) {
            this.heap = arr;
        }

        public void push(int value) {
            int i = size;
            heap[size++] = value;

            // bubble up if smaller
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap[i] >= heap[parent]) {
                    break;
                }

                // swap with parent
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;

                i = parent;
            }
        }

        public int replace(int value) {
            if (size == 0 || value <= heap[0]) {
                return value;
            }

            int smallest = heap[0];
            heap[0] = value;

            // siftDown
            int i = 0;
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int swap = i;
                if (left < size && heap[left] < heap[swap]) {
                    swap = left;
                }
                if (right < size && heap[right] < heap[swap]) {
                    swap = right;
                }
                if (swap == i) {
                    break;
                }

                // swap
                int temp = heap[swap];
                heap[swap] = heap[i];
                heap[i] = temp;

                i = swap;
            }

            return smallest;
        }
    }

}
