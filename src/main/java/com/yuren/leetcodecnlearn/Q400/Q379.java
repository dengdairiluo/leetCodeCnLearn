package com.yuren.leetcodecnlearn.Q400;

import java.util.ArrayList;
import java.util.List;

public class Q379 {
    /**
     * 号码本
     */
    int[] phoneArr;
    /**
     * 可使用的空闲数组
     */
    List<Integer> list;
    /**
     * 记录剩余号码可用数量
     */
    int resNum;
    int index;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public Q379(int maxNumbers) {
        /**
         * 根据题意需要使用两套list存储
         * 一套是已分配的号码本方便的存储已有号码
         * 一套是未分配的号码集合
         * 一个是剩余可用号码数量
         * 使用一个数组
         * 初始状态为0 分配后置为1
         */
        resNum = maxNumbers;
        list = new ArrayList<>();
        phoneArr = new int[maxNumbers];
        index = 0;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (resNum == 0) {
            return -1;
        }
        int len = phoneArr.length;
        resNum--;
        int res = -1;
        // 当存储空间还够的时候则直接顺序取下一个号码
        if (index < len) {
            phoneArr[index] = 1;
            res = index;
        } else {
            // 当索引已经超过了它的范围则去寻找已释放的元素
            if (list.size() == 0) {
                return -1;
            }
            // 在释放元素里找到我们元素 置为一 并去除释放项
            int item = list.get(0);
            phoneArr[item] = 1;
            res = item;
            list.remove(0);

        }
        index++;
        return res;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        if (number < 0 || number >= phoneArr.length) {
            return false;
        }
        return phoneArr[number] == 0;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        // 当数组中的number本来就是0 没必要加入release数组
        if (number < 0 || number >= phoneArr.length || phoneArr[number] == 0) {
            return;
        }
        phoneArr[number] = 0;
        list.add(number);
        resNum++;
    }
}
