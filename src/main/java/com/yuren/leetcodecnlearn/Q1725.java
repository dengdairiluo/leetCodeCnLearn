package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-06 23:18
 */
public class Q1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int a;
        int max=0;
        int count=1;
        for(int i=0; i<rectangles.length; i++){
            a = Math.min(rectangles[i][0], rectangles[i][1]);
            if(a>max){
                max = a;
                count=1;
            }else if(a==max){
                count++;
            }
        }
        return count;
    }
}
