package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-02-14 17:32
 */
public class MST0804 {

    /**
     * 每新增一个元素，都是增加原元素所有子集加上该元素
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> resSet = new ArrayList<>(1 << nums.length);
        resSet.add(new ArrayList<>());

        for (int num : nums) {
            for (int i = 0, n = resSet.size(); i < n; i++) {
                List<Integer> list = new ArrayList<>(resSet.get(i));
                list.add(num);
                resSet.add(list);
            }
        }

        return resSet;
    }

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //做出选择
            tempList.add(nums[i]);
            //递归
            backtrack(list, tempList, nums, i + 1);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }
}
