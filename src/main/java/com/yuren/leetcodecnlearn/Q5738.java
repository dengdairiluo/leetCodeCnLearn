package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-25 21:20
 */
public class Q5738 {
    /**
     * 计算每个数字，各个数位的求和
     * @param n 非负十进制整数
     * @param k 进制
     * @return sum 各个数位的求和
     */
    public int sumBase(int n, int k) {
        int sum = 0;
        // int ik =  Integer.valueOf(binary(n, k));
        // System.out.println(binary(n, k));
        char[] chs = binary(n, k).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            // System.out.println(Integer.valueOf(chs[i])-48);
            sum += Integer.valueOf(chs[i]-48); //0的ASCII值是48
        }
        return sum;
    }

    /**
     * 除二取余法
     * 非负十进制整数n转换成k进制，其中2<=k<=16
     * 递归：
     * fun(n) = n, n<=k
     * 	      = n%k + fun(n/k), k<n<=16
     * @param n 非负十进制整数
     * @param k 进制
     * @return String 由于像16进制会带ABCDEF等后缀
     */
    public static String binary(int n,int k) {
        if(n<k) {
            if(n<10) {
                return String.valueOf(n);
            } else if(10==n)	return "A";
            else if(11==n)	return "B";
            else if(12==n)	return "C";
            else if(13==n)	return "D";
            else if(14==n)	return "E";
            else	return "F";
        } else {
            if((n%k)<10)
                return binary(n/k,k).concat(String.valueOf(n%k));
            if((n%k)==10)
                return binary(n/k,k).concat("A");
            else if((n%k)==11)
                return binary(n/k,k).concat("B");
            else if((n%k)==12)
                return binary(n/k,k).concat("C");
            else if((n%k)==13)
                return binary(n/k,k).concat("D");
            else if((n%k)==14)
                return binary(n/k,k).concat("E");
            else
                return binary(n/k,k).concat("F");
        }
    }
}
