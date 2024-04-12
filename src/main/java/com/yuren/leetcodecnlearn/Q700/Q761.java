package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-02 23:28
 */
public class Q761 {
    //快速排序
    public static void quickSort(String arr[], int low, int high) {
        int i = low;//i是向后搜索的指针
        int j = high;//j是向前搜索的指针
        String temp = arr[i];
        while (i < j) {
            while (i < j && arr[j].compareTo(temp) >= 0) {
                j--;//arr[j]不小于基准，不用交换，继续向前搜索
            }
            if (i < j) {
                arr[i++] = arr[j];//比基准小的移到前面
                //i++;
            }
            while (i < j && arr[i].compareTo(temp) <= 0) {
                i++;//arr[i]不大于基准，不用交换，继续向后搜索
            }
            if (i < j) {
                arr[j--] = arr[i];//比基准大的移到后面
                //j--;
            }
        }
        arr[i] = temp;//确定基准记录位置
        if (low < i - 1) {
            quickSort(arr, low, i - 1);//递归处理左子区
        }
        if (high > i + 1) {
            quickSort(arr, i + 1, high);//递归处理左子区
        }
    }

    public String makeLargestSpecial(String s) {
        //1.找出特殊二进制序列中的特殊子串
        if (s.length() <= 1) return s;//结束条件
        List<String> list = new ArrayList<>();//用来存储连续的字串，并且符合要求的子串必须是1开头0结尾
        StringBuilder sb = new StringBuilder();
        int start = 0;//用来声明下一个特殊字串开始的位置
        int count = 0;//计数器，通过记录子1和0的数量判断是否为一个特殊子串
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;//每逢1则计数器+1，逢0则减一
            if (count == 0) {//当count等于0时，说明得到一个特殊的二进制序列
                String str = s.substring(start + 1, i);//获得去除首尾后的子序列，形成递归
                String result = makeLargestSpecial(str);//对子序列求字典序排列
                list.add("1" + result + "0");//对子序列添加之前去除的首尾1和0，并存储到list集合中
                start = i + 1;//start为下一个特殊子串开始的位置
            }
        }
        //2.将特殊子串按照字典序排列
        //toArray()方法会返回List中所有元素构成的数组
        //toArray[T[] a]方法会返回List中所有元素构成的指定类型的数组
        String[] arr = list.toArray(new String[list.size()]);
        quickSort(arr, 0, arr.length - 1);//对数组中的特殊子串进行快速排序
        //由于快排后为从小到大，所以再进行逆序
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();//返回排序后的字符串
    }
}
