package com.yuren.leetcodecnlearn.Q2100;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-15 21:42
 */
public class Q2115 {
    List<List<String>> f;
    String[] x;
    Set<String> g = new HashSet<>();
    Map<String, Integer> p = new HashMap<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        this.x = recipes;
        this.f = ingredients;
        g.addAll(Arrays.asList(supplies));
        for (int i = 0; i < recipes.length; i++) {
            p.put(recipes[i], i);
        }
        int[] r = new int[recipes.length];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            if (dfs(i, r)) {
                list.add(recipes[i]);
            }
        }
        return list;
    }

    private boolean dfs(int i, int[] r) {
        if (r[i] == 2) return true;
        if (r[i] == 1) return false;
        if (r[i] == 0) r[i] = 1;
        boolean isx = true;
        //判断它需要什么原材料
        List<String> list = f.get(i);
        for (String s : list) {
            if (g.contains(s)) {
                continue;
            }
            if (p.containsKey(s)) {
                Integer integer = p.get(s);
                if (!dfs(integer, r)) {
                    isx = false;
                    break;
                }
                continue;
            }
            isx = false;
            break;
        }
        if (isx) {
            r[i] = 2;
        }
        return isx;
    }
}
