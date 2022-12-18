package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-25 23:32
 */
public class Q1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //既然两个子数组不能重叠，那么就必定存在以下情况
        //假设数组[1,5,4,7,8,2,1,1,5] ,我们假设firstLen选中2--5个数字，secondLen选中了7--9个数字
        //那么实际上原来的数组必然被分成了两份，而对于以上的例子，第七个数字我们就可以看成是分界线
        //所以我们需要记录左半边以及右半边长度为firstLen及secondLen的子数组的最大数，中界限从左往右以此推移
        //令dp[i][0]为中介线为i的时候firstLen在左侧的最大值，dp[i][1]为firstLen在右侧的最大值，
        // dp[i][2]为secondLen在左侧的最大值，dp[i][3]为secondLen在右侧的最大值
        int[][] dp = new int[nums.length][4];
        //如何求dp，需要从左边往右边遍历，左半边最大的firstLen和secondLen子数组最大值
        //然后从右边往左边遍历，求出右边最大的firstLen和secondLen子数组最大值
        int maxFirstLen = 0;
        int maxSecondLen = 0;
        int firstLenT = 0;
        int secondLenT = 0;
        for (int i = 0; i < nums.length; i++) {
            //从左往右遍历
            firstLenT += nums[i];
            secondLenT += nums[i];
            int numCount = i + 1;
            if (numCount >= firstLen) {
                if (numCount > firstLen) {
                    //弹出前部窗口外的元素
                    firstLenT -= nums[i - firstLen];
                }
                maxFirstLen = firstLenT > maxFirstLen ? firstLenT : maxFirstLen;
            }
            if (numCount >= secondLen) {
                if (numCount > secondLen) {
                    //弹出前部窗口外的元素
                    secondLenT -= nums[i - secondLen];
                }
                maxSecondLen = secondLenT > maxSecondLen ? secondLenT : maxSecondLen;
            }
            dp[i][0] = maxFirstLen;
            dp[i][2] = maxSecondLen;
        }
        maxFirstLen = 0;
        maxSecondLen = 0;
        firstLenT = 0;
        secondLenT = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            //从右往左遍历
            firstLenT += nums[i];
            secondLenT += nums[i];
            //0,1,2,3,4,5
            int numCount = nums.length - i;
            if (numCount >= firstLen) {
                if (numCount > firstLen) {
                    //弹出后部窗口外的元素
                    firstLenT -= nums[nums.length - (numCount - firstLen)];
                }
                maxFirstLen = firstLenT > maxFirstLen ? firstLenT : maxFirstLen;
            }
            if (numCount >= secondLen) {
                if (numCount > secondLen) {
                    //弹出后部窗口外的元素
                    secondLenT -= nums[nums.length - (numCount - secondLen)];
                }
                maxSecondLen = secondLenT > maxSecondLen ? secondLenT : maxSecondLen;
            }
            dp[i][1] = maxFirstLen;
            dp[i][3] = maxSecondLen;
        }
        //不断变换中界线，找到最大的
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果中界线两边的元素个数不足以容纳firstLen及secondLen个元素，则跳过本次判断
            //先判断左侧为firstLen的情况
            if (i >= firstLen && nums.length - i >= secondLen) {
                int sumT = dp[i - 1][0] + dp[i][3];
                result = sumT > result ? sumT : result;
            }
            //判断左侧取secondLen，右侧取firstLen的情况
            if (i >= secondLen && nums.length - i >= firstLen) {
                int sumT = dp[i - 1][2] + dp[i][1];
                result = sumT > result ? sumT : result;
            }
        }
        return result;
    }
}
