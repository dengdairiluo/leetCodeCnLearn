package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-23 23:37
 */
public class Q471 {
    /**
     * 统计数字位数
     *
     * @param num
     * @return
     */
    public int getLength(int num) {
        int length = 1;
        while (num >= 10) {
            num /= 10;
            length++;
        }
        //返回长度
        return length;

    }

    /**
     * 深度遍历  2[2[abbb]c]"  处理树状结构
     */
    public void dfs(StringBuilder result, char[] sch, int[][] minLens, int start, int len) {
        //结束位置
        int end = start + len;
        for (int i = start; i < end; ) {
            //保存当前数组最短长度
            int minLen = minLens[i][len];
            if (minLen == len) {
                //插入长度，返回
                result.append(sch, i, len);
                return;
            }
            int j = 1;
            //循环终止，minLen==minLens[i][j]+minLens[i+j][len-j]
            while (j < len && minLen != minLens[i][j] + minLens[i + j][len - j]) {
                j++;
            }
            if (j == 1) {
                //单字符直接加上
                result.append(sch[i]);
            } else {
                int k = 1;
                //j%k==0  整除，2[abbb]
                while (k <= j && (j % k != 0 || getLength(k) + 2 + minLens[i][j / k] != minLens[i][j])) {

                    k++;
                }
                //k重复
                //重叠
                result.append(k).append('[');
                //递归
                dfs(result, sch, minLens, i, j / k);
                result.append(']');
            }
            //跳过j个字符
            i += j;
            //长度减去j
            len -= j;

        }
    }

    public String encode(String s) {
        //取得长度
        int n = s.length();
        //"aaa" 3[a]
        if (n < 4) {
            //直接返回
            return s;
        }
        //字符数组
        char[] sch = s.toCharArray();
        //循环保存最短长度
        int[][] minLens = new int[n][];
        minLens[n - 1] = new int[]{0, 1};
        //kmp算法
        //开辟数组
        int[] kmp = new int[n + 1];
        //标记-1
        kmp[0] = -1;
        //搜索数组
        //从后往前检索字符
        for (int i = n - 2; i >= 0; i--) {
            //初始化二维数组得每个一维数组
            minLens[i] = new int[n - i + 1];
            //标记1最短
            int minLen = minLens[i][1] = 1;
            //二层循环
            for (int j = 1, k = 0; i + j < n; ) {
                //取得当前字符
                char c = sch[i + j];
                //循环终止条件c==sch[i+k]
                while (k >= 0 && c != sch[i + k]) {
                    //找到一个重合
                    k = kmp[k];
                }
                //记录kmp
                kmp[++j] = ++k;
                //长度++
                minLen++;
                //循环
                for (int l = 1; l + 1 < j; l++) {
                    //保存最短
                    minLen = Math.min(minLen, minLens[i][l] + minLens[i + l][j - l]);

                }
                //可以整除,   "aabcaabcd"  "2[aabc]d"  getlength(j/(j-k))->2  [] 2
                if (k > 0 && j % (j - k) == 0) {
                    minLen = Math.min(minLen, getLength(j / (j - k)) + 2 + minLens[i][j - k]);
                }
                //保存最短
                minLens[i][j] = minLen;
            }

        }
        //没有重复
        if (minLens[0][n] == n) {
            //直接返回
            return s;
        }


        //深度遍历保存结果
        StringBuilder sb = new StringBuilder();
        //深度遍历
        dfs(sb, sch, minLens, 0, n);
        //返回
        return sb.toString();


    }

}
