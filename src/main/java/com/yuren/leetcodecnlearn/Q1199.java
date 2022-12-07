package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-07 23:22
 */
public class Q1199 {
    public int minBuildTime(int[] blocks, int split) {
        if (blocks.length == 1) {
            return blocks[0];
        }
        int max = 0;
        for (int v : blocks) {
            max = Math.max(v, max);
        }
        int n = blocks.length;
        //分裂次数
        int time = 0;
        while ((1 << time) < blocks.length) {
            ++time;
        }

        int left = blocks[blocks.length - 1];
        int right = time * split + max;
        while (left < right) {
            int use = (right - left) / 2 + left;
            if (canPass(use, blocks, split, time)) {
                //尝试减小
                right = use;
            } else {
                left = use + 1;
            }
        }
        return right;
    }

    private boolean canPass(int hopeTime, int[] blocks, int split, int time) {
        int n = blocks.length;
        int[] splitCnt = new int[12];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int splitTimes = time;
            while (blocks[i] + splitTimes * split > hopeTime) {
                --splitTimes;
            }

            if (splitTimes <= 0) {
                return false;
            }
            splitCnt[splitTimes]++;
            max = Math.max(splitTimes, max);
        }
        max = Math.min(time - 1, max);
        int total = 1;
        for (int i = 1; i <= max; i++) {
            total = total * 2;
            total -= splitCnt[i];
            if (total < 0) {
                return false;
            }
        }

        return true;
    }
}
