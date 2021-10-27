package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-27 23:34
 */
public class Q248 {
    private final char[][] mapping = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    public int count = 0;

    /**
     * 计算范围在 [low, high] 之间中心对称数的个数。
     *
     * @param low
     * @param high
     * @return
     */
    public int strobogrammaticInRange(String low, String high) {
        int lo = low.length();
        int hi = high.length();
        // 获取长度 [lo, hi] 区间的中心对称数
        for (int n = lo; n <= hi; n++) {
            char[] chs = new char[n];
            getStrobogrammatic(chs, 0, chs.length - 1, low, high);
        }
        return count;
    }

    /**
     * 填充可能的中心对称数到 chs
     * @param chs
     * @param lo    左指针
     * @param hi    右指针
     * @param low   下限
     * @param high  上限
     */
    public void getStrobogrammatic(char[] chs, int lo, int hi, String low, String high) {
        if (lo > hi) {  // 填充完毕，开始统计个数
            if (chs.length == 1 || chs[0] != '0') { // 如果 chs 长度为 1，则有效，否则第 0 个元素不能为 '0'
                String str = String.valueOf(chs);
                if (compare(str, low) && compare(high, str)) {
                    count++;
                }
            }
            return;
        }
        // 遍历 lo 和 hi 的可能取值
        for (char[] map : mapping) {
            if (lo == hi && map[0] != map[1]) continue; // 正中间不可以是 6 或者 9
            chs[lo] = map[0];   // 0 1 8
            chs[hi] = map[1];   // 0 1 8
            getStrobogrammatic(chs, lo + 1, hi - 1, low, high);
        }
    }

    /**
     * 判断 s1 是否大于 s2
     * @param s1
     * @param s2
     * @return
     */
    public boolean compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.compareTo(s2) >= 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
