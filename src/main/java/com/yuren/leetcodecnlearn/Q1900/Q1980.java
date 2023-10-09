package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-09 23:49
 */
public class Q1980 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }
}
