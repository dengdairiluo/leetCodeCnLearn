package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-25 23:31
 */
public class Q1326 {
    public int minTaps(int n, int[] ranges) {
        int cur = -1, rightmost = 0;
        int[] choices = new int[(n + 1) / 2];

        for (int i = 0; i <= n; i++) {
            //如果水龙头范围为0，直接跳过
            if (ranges[i] == 0) {
                continue;
            }
            int right = Math.min(ranges[i] + i, n);
            //如果水龙头扩大不了范围，直接跳过
            if (right <= rightmost) {
                continue;
            }
            int left = Math.max(i - ranges[i], 0);
            //如果水龙头连接不起来，直接跳过
            if (left > rightmost) {
                continue;
            }
            //如果水龙头能浇灌到0，则清空已选
            if (left == 0) {
                cur = -1;
            } else {
                //如果已经选择了两个以上的水龙头了，根据能否与已选择的倒数第二个水龙头连起来，判断是否要舍弃倒数第一个水龙头，并循环
                while ((cur >= 1 && left <= choices[cur - 1])) {
                    cur--;
                }
            }
            //把当前水龙头加入已选择
            cur++;
            choices[cur] = right;
            rightmost = right;
        }

        //没选出水龙头，或者浇灌长度不够返回-1
        if (cur == -1 || rightmost < n) {
            return -1;
        }

        return cur + 1;
    }
}
