package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-23 11:42
 */
public class MST0807 {
    private final List<String> list = new ArrayList<>();

    public String[] permutation(String S) {
        char[] chas = S.toCharArray();
        dfs(chas, 0);
        String[] res = new String[list.size()];
        return list.toArray(res);
    }


    /**
     * @param chas
     * @param idx  当前遍历的chas的下标
     */
    private void dfs(char[] chas, int idx) {
        if (idx == chas.length - 1) {//返回
            list.add(String.valueOf(chas));
            return;
        }
        for (int i = idx; i < chas.length; i++) {
            swap(chas, i, idx);//交换
            dfs(chas, idx + 1);//当前的idx+1 进入下一轮
            swap(chas, i, idx);//回溯
        }
    }

    private void swap(char[] chas, int i, int j) {
        char t = chas[i];
        chas[i] = chas[j];
        chas[j] = t;
    }

}
