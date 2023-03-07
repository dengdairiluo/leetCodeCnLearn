package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-25 20:47
 */
public class Q402 {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        int index = 0;
        //从前往后遍历字符串, 时间复杂度O(n)
        while (k > 0) {
            //剩下的数字是升序, 则只取前面部分
            if (index >= sb.length() - 1) {
                return sb.substring(0, sb.length() - k);
            }
            //前面数字大于后面的, 删除前面的, k减1, 索引减1(索引>0, 因为还要比较后面这个与之前的大小)
            if (sb.charAt(index) > sb.charAt(index + 1)) {
                sb.deleteCharAt(index);
                if (index > 0) {
                    index--;
                }
                k--;
            } else {
                //前面数字小于后面的, 索引加1
                index++;
                continue;
            }
            //去掉前面无效的0
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            //剩下字符串长度小于当前k, 结束
            if (k >= sb.length()) {
                return "0";
            }
        }
        return sb.toString();
    }
}
