package com.yuren.leetcodecnlearn;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-28 23:41
 */
public class Q411 {
    private int minAbbrLen = Integer.MAX_VALUE, minAbbrBinary = -1;

    public String minAbbreviation(String target, String[] dictionary) {
        int len = target.length();
        ArrayList<String> dic = new ArrayList<>();
        for (String s : dictionary) {
            if (s.length() == len) {
                dic.add(s);
            }
        }
        //没有相等长度字符
        if (dic.size() == 0) {
            return Integer.toString(len);
        }
        int[] dicBinary = new int[dic.size()];
        char c;
        for (int i = 0; i < len; ++i) {
            c = target.charAt(i);
            for (int j = 0; j < dicBinary.length; ++j) {
                if (c == dic.get(j).charAt(i)) {
                    dicBinary[j] |= 1 << i;
                }
            }
        }
        getTargetAbbrBinary(len, 0, dicBinary, 0, true, 1);
        return binaryToString(minAbbrBinary, target);
    }

    private boolean valid(int targetBinary, int[] dicBinary) {
        for (int i = 0; i < dicBinary.length; ++i) {
            //说明这种缩写已存在
            if ((targetBinary & dicBinary[i]) == targetBinary) {
                return false;
            }
        }
        return true;
    }

    private String binaryToString(int binary, String target) {
        StringBuilder sb = new StringBuilder();
        int count0 = 0;
        for (int i = 0; i < target.length(); ++i) {
            if ((1 << i & binary) == 0) {
                ++count0;
            } else {
                if (count0 > 0) {
                    sb.append(count0);
                    count0 = 0;
                }
                sb.append(target.charAt(i));
            }
        }
        if (count0 > 0) {
            sb.append(count0);
        }
        return sb.toString();
    }

    private void getTargetAbbrBinary(int bits, int pos, int[] dicBinary, int prev, boolean prevBitIsOne, int len) {
        if (pos == bits) {
            return;
        }
        int curLen = len;
        //最后一位
        if (pos == bits - 1) {
            //前一位是数字 数字值-1 字符+1
            if (!prevBitIsOne) {
                ++curLen;
            }
        } else {
            //前一位是字符 数字值-1 字符+1
            if (prevBitIsOne) {
                ++curLen;
                //前一位是数字 字符从中把数字分成两个 数字+1 字符+1
            } else {
                curLen += 2;
            }
        }
        if (curLen < minAbbrLen) {
            //1
            if (valid(1 << pos | prev, dicBinary)) {
                minAbbrBinary = 1 << pos | prev;
                minAbbrLen = curLen;
                return;
            }
            getTargetAbbrBinary(bits, pos + 1, dicBinary, 1 << pos | prev, true, curLen);
        }
        //0
        getTargetAbbrBinary(bits, pos + 1, dicBinary, prev, false, len);
    }

}
