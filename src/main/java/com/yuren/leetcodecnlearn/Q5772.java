package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-30 23:09
 */
public class Q5772 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sum = 0;
        boolean flag = false;
        int one = firstWord.length() - 1;
        int two = secondWord.length() - 1;
        int tar = targetWord.length() - 1;
        StringBuffer ans = new StringBuffer();
        while(tar >= 0){
            if(flag) {
                sum = 1;
            } else {
                sum = 0;
            }
            if(one >= 0 && two >= 0) {
                sum += firstWord.charAt(one--) + secondWord.charAt(two--) - 'a' - 'a';
                //System.out.println(sum);
                if(sum > 9) {flag = true; sum -= 10;}
                else {
                    flag = false;
                }
                if((targetWord.charAt(tar--) - 'a') != sum) {
                    return false;
                }
            }
            else if(one >= 0) {
                sum += firstWord.charAt(one--) - 'a';
                if(sum > 9) {flag = true; sum -= 10;}
                else {
                    flag = false;
                }
                if((targetWord.charAt(tar--) - 'a') != sum) {
                    return false;
                }
            }

            else if(two >= 0) {
                sum += secondWord.charAt(two--) - 'a';
                if(sum > 9) {flag = true; sum -= 10;}
                else {
                    flag = false;
                }
                if((targetWord.charAt(tar--) - 'a') != sum) {
                    return false;
                }
            }
            else if(targetWord.charAt(tar) == 'b' && flag) {flag = false; tar--;}
            else if(flag) {
                return false;
            } else if(targetWord.charAt(tar--) == 'a') {
                ;
            } else {
                return false;
            }
        }
        return true;


    }
}
