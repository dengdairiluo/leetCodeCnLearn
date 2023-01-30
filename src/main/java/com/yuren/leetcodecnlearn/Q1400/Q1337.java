package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-31 00:19
 */
public class Q1337 {
    public int[] kWeakestRows(int[][] mat, int k) {

        // 1.准备哈希表 map[0] 放索引  map[1] 放战斗力
        int[][] map = new int[mat.length][2];
        for(int i = 0;i<mat.length;i++){
            int score = getCore(mat[i]);
            map[i] = new int[]{i,score};
        }

        // 2.进行快速排序
        sort(map);

        // 3.排序后放到结果数组中 返回
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = map[i][0];
        }
        return res;
    }

    private void sort(int[][] array){
        sort(array,0,array.length-1);
    }

    private void sort(int[][] array, int low, int high){
        if(low > high) {
            return;
        }

        int mid = partition(array,low,high);
        sort(array,low,mid-1);
        sort(array,mid+1,high);
    }


    private int partition(int[][] array,int low,int high){
        int pivot = array[low][1];
        int index = array[low][0];

        int start = low + 1;
        int end = high;

        while(end >= start){

            if(array[end][1] > pivot || (array[end][1] == pivot && array[end][0]> index) ){
                end--;
            }else if(array[start][1] < pivot || (array[start][1] == pivot && array[start][0] < index) ){
                start++;
            }else{
                // end < pivot && start >= pivot
                int[] tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
        //start = end + 1
        int[] tmp = array[low];
        array[low]= array[end];
        array[end] = tmp;


        return end;

    }




    private int getCore(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        //res 为 第一个为1的索引  没有则为-1
        int res = -1;  
        while(high >= low){
            int mid = (high - low)/2 + low;

            if(arr[mid] == 0){
                high = mid - 1;
            }else{
                res = mid;
                low = mid + 1;
            }
        }
        return res + 1;
    }
}
