package com.yuren.leetcodecnlearn.Q700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-12 21:51
 */
public class Q682 {
    public int calPoints(String[] ops) {
//列表存储数据
        List<Integer> list = new ArrayList<>();
        //遍历数组
        for (int i = 0; i < ops.length; ++i) {
            //如果等于C，表示前一次得分无效，将其从记录中移除。
            if ("C".equals(ops[i])) {
                list.remove(list.size() - 1);
                //表示本回合新获得的得分是前一次得分的两倍
            } else if ("D".equals(ops[i])) {
                list.add(list.get(list.size() - 1) * 2);
                //表示本回合新获得的得分是前两次得分的总和
            } else if ("+".equals(ops[i])) {
                list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
            } else {
                //字符串表示的数字加入列表
                list.add(Integer.valueOf(ops[i]));
            }
        }
        //对列表所有元素求和
        int sum = 0;
        for (int elem : list) {
            sum += elem;
        }
        return sum;

    }
}
