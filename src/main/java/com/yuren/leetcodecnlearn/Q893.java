package com.yuren.leetcodecnlearn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-18 06:42
 */
public class Q893 {
    public int numSpecialEquivGroups1(String[] words) {
        Set<String> set = new HashSet<>();
        for (String str : words) {
            char[] chars = str.toCharArray();
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                //如果是奇数位
                if ((i & 1) == 1) {
                    odd.append(str.charAt(i));
                } else {
                    //如果为偶数位
                    even.append(str.charAt(i));
                }
            }
            //排序后拼接
            char[] oddArr = odd.toString().toCharArray();
            Arrays.sort(oddArr);
            char[] evenArr = even.toString().toCharArray();
            Arrays.sort(evenArr);
            set.add(new String(oddArr) + new String(evenArr));
        }

        return set.size();


    }

}
