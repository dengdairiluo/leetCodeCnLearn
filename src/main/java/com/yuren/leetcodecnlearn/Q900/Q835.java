package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-03 23:36
 */
public class Q835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int imgLength = img1.length;
        int middle = imgLength - 1;
        //img1 转换成数字
        int[] nums1 = DimensionReduction(img1);

        //img2 转换成数字
        int[] nums2 = DimensionReduction(img2);

        //图像重叠的一的最大个数
        int maxOverlap = 0;

        //img1 左移和右移
        int movesLength = imgLength << 1;
        // img1 左右移动后的图像数组
        //int[][] img1Moves = new int[movesLength - 1][imgLength];
        int maxCount = 0;
        for (int i = middle; i > 0; i--) {
            // nums1左移后添加到img1Moves中
            //img1Moves[middle - i] = sways(nums1, i, -1); // 下标左边开始
            // nums1右移后添加到img1Moves中
            //img1Moves[middle + i] = sways(nums1, i, 1); // 下标从右边开始
            //左移
            maxCount = getMaxCount(sways(nums1, i, -1), nums2);
            if (maxCount > maxOverlap) {
                maxOverlap = maxCount;
            }
            //右移
            maxCount = getMaxCount(sways(nums1, i, 1), nums2);
            if (maxCount > maxOverlap) {
                maxOverlap = maxCount;
            }
        }
        //img1Moves[imgLength - 1] = nums1;
        //for (int i = 0; i < movesLength - 1; i++) {
        //    int maxCount = getMaxCount(img1Moves[i], nums2);
        //    if (maxCount > maxOverlap) {
        //        maxOverlap = maxCount;
        //   }
        //}

        maxCount = getMaxCount(sways(nums1, 0, 0), nums2);
        if (maxCount > maxOverlap) {
            maxOverlap = maxCount;
        }

        return maxOverlap;
    }

    /**
     * 左右移动
     *
     * @param srcArray  要移动的数组
     * @param step      移动步长
     * @param direction 移动方向 0:不移动 -1:左移 1: 右移
     * @return 向左或者向右移动 step 步长后的数组
     */
    public int[] sways(int[] srcArray, int step, int direction) {
        int[] res = new int[srcArray.length];
        // 不移动
        if (direction == 0) {
            res = srcArray;
        }
        // 左移
        if (direction < 0) {
            for (int i = 0; i < srcArray.length; i++) {
                res[i] = srcArray[i] << step;
            }
        } else {
            for (int i = 0; i < srcArray.length; i++) {
                res[i] = srcArray[i] >> step;
            }
        }
        return res;
    }


    /**
     * 将二维图像转换成一维数组
     *
     * @param imag 二维图像
     * @return 转换后的一维数组
     */
    public int[] DimensionReduction(int[][] imag) {
        int[] result = new int[imag.length];
        for (int i = 0; i < imag.length; i++) {
            int n = 0;
            for (int j = 0; j < imag[i].length; j++) {
                if (imag[i][j] == 1) {
                    n |= 1 << (imag[i].length - j - 1);
                }
            }
            result[i] = n;
        }
        return result;
    }

    /**
     * 计算moveArray向上或者向下移动 1 ~ (moveArray.length - 1) 步长后
     * 与 一维图像 motArray 重叠的一的最大个数
     *
     * @param moveArray 移动后的数组(图像左移或者右移后的一维数组)
     * @param motArray  二维图像数组转换后的一维数组
     * @return 重叠的一的最大个数
     */
    public int getMaxCount(int[] moveArray, int[] motArray) {
        int length = moveArray.length;
        int res = calculateOverlapOnes(moveArray, motArray);
        int[] temp = null;
        int compare = 0;
        //上移
        for (int i = 1; i < length; i++) {
            temp = new int[length];
            for (int j = 0; j < length - i; j++) {
                temp[j] = moveArray[j + 1];
            }

            compare = calculateOverlapOnes(temp, motArray);
            if (compare > res) {
                res = compare;
            }
        }

        //下移
        for (int i = 1; i < length; i++) {
            temp = new int[length];
            for (int j = 0; j < length - i; j++) {
                temp[j + i] = moveArray[j];
            }

            compare = calculateOverlapOnes(temp, motArray);
            if (compare > res) {
                res = compare;
            }
        }

        return res;
    }

    /**
     * 计算移动后的图像重叠的一的个数
     *
     * @param moveArray 移动后的二维图像数组转换成的一维数组
     * @param motArray  二维图像数组转换成的一维数组
     * @return 图像移动后一的重叠个数
     */
    public int calculateOverlapOnes(int[] moveArray, int[] motArray) {
        int res = 0;
        if (moveArray.length != motArray.length) {
            return res;
        }
        for (int i = 0; i < motArray.length; i++) {
            res += CountTheNumberOfOnes(moveArray[i] & motArray[i]);
        }
        return res;
    }

    /**
     * 计算一个 int 二进制中的 1 的个数
     *
     * @param n 需要计算的数
     * @return 一的个数
     */
    public int CountTheNumberOfOnes(int n) {
        int oneCount = 0;
        while (n != 0) {
            n = (n & (n - 1));
            oneCount++;
        }
        return oneCount;
    }
}
