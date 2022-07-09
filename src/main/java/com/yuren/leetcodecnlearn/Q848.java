package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-09 22:32
 */
public class Q848 {
    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        // 有庞大的测试用例，会破防，所以用long
        long[] cnts = new long[len];
        // 先复制shifts数组
        for(int i=0; i<len; i++){
            cnts[i] = shifts[i];
        }
        // 计算总的偏移次数
        for(int i=len-1; i>=1; i--){
            cnts[i-1] += cnts[i];
        }
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 把字母移位，最终结果放在StringBuilder
        for(int i=0; i<len; i++){
            char ch = sArr[i];
            long chNum = ch - 'a';
            chNum = (chNum + cnts[i]) % 26;
            sb.append((char) (chNum + 'a'));
        }
        return sb.toString();
    }
}
