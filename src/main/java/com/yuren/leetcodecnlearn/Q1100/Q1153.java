package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-16 23:50
 */
public class Q1153 {
    public boolean canConvert(String str1, String str2) {
        int len = str1.length();
        if (len <= 1 || str1.equals(str2)) {
            // 两个字符串完全相等时，会影响后面上游字母的判定，所以先在这里判断了
            return true;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // 记录下游情况，下游分叉则不可转换
        char[] lowerReaches = new char['z' + 1];
        // 记录上游情况，用来标记空闲字母，如果一个字母没有上游，则算作空闲字母(初始状态就是空闲的，或者经过一定步骤转换后可以变为空闲状态)
        // 如果有空闲字母，且不存在下游分叉的情况，一定可以转换
        char[] upperReaches = new char['z' + 1];
        int freeCharNum = 26;
        for (int i = 0; i < len; i++) {
            char char1 = chars1[i];
            char char2 = chars2[i];

            if (lowerReaches[char1] != 0 && lowerReaches[char1] != char2) {
                // 该字母下游分叉，不可转换
                return false;
            } else {
                // 更新 char2 的上游字母情况
                char upperReach = upperReaches[char2];
                if (upperReach == 0) {
                    if (--freeCharNum == 0) {
                        return false;
                    }
                    upperReaches[char2] = char1;
                }
                // 更新 char2 的下游字母情况
                lowerReaches[char1] = char2;
            }
        }
        return true;
    }
}
