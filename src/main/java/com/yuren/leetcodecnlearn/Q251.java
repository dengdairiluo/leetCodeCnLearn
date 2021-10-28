package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-28 22:55
 */
public class Q251 {
    int i;
    int j;
    int[][] v;
    public Q251(int[][] v) {
        this.i = 0;
        this.j = 0;
        this.v = v;
    }

    public int next() {
        while(this.v[i].length == 0){
            i ++;
            j=0;
        }
        int res = this.v[i][j];
        if (j < this.v[i].length - 1){
            j++;
        }
        else{
            i++;
            j = 0;
        }
        return res;
    }

    public boolean hasNext() {

        try{
            while(this.v[i].length == 0){
                i ++;
                j=0;
            }
            if (this.i < this.v.length && this.j < this.v[this.i].length) return true;
            else return false;
        }
        catch(Exception e){
            return false;
        }
    }
}
