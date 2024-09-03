package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-03 22:51
 */
public class Q2638 {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        List<Integer> []group = new List[k];
        Arrays.setAll(group, o->new ArrayList<>());
        Arrays.sort(nums);
        for (int num : nums) {
            group[num%k].add(num);
        }
        long ans = 1;
        for(List<Integer> sameMod:group){
            if(sameMod.isEmpty()) continue;
            long a = 1;
            long b = 2;
            for(int i = 1; i < sameMod.size(); i++){
                if(sameMod.get(i)==sameMod.get(i-1)+k){
                    long c = a+b;
                    a = b;
                    b = c;
                }else{
                    ans *= b;
                    a = 1;
                    b = 2;
                }
            }
            ans *= b;
        }
        return ans;
    }
}
