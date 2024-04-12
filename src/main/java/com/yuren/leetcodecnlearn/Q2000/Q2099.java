package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-07 23:22
 */
public class Q2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        int leftNumber = nums.length - k;
        int[] ans = new int[k];
        Heap heap = new Heap(nums.length);
        for (int number : nums) {
            heap.add(number);
        }
        while (leftNumber > 0) {
            int smallNumber = heap.poll();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == smallNumber) {
                    nums[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            leftNumber--;
        }
        for (int i = 0; i < ans.length; i++) {
            while (nums[leftNumber] == Integer.MAX_VALUE) {
                leftNumber++;
            }
            ans[i] = nums[leftNumber++];
        }
        return ans;
    }

    private static class Heap {
        int[] data;
        int size;

        public Heap(int n) {
            data = new int[n];
            size = 0;
        }

        private void swap(int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        private void siftUp(int index) {
            int parent = (index - 1) / 2;
            while (data[index] < data[parent]) {
                swap(index, parent);
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        private void siftDown(int index) {
            int left = (index * 2) + 1;
            while (left < size) {
                int smalllest = data[index] <= data[left] ? index : left;
                smalllest = left + 1 >= size ? smalllest :
                        data[smalllest] <= data[left + 1] ? smalllest : left + 1;
                if (smalllest == index) {
                    break;
                }
                swap(smalllest, index);
                index = smalllest;
                left = (index * 2) + 1;
            }
        }

        public void add(int number) {
            data[size] = number;
            siftUp(size++);
        }

        public int poll() {
            int ans = data[0];
            swap(0, --size);
            siftDown(0);
            return ans;
        }
    }

}
