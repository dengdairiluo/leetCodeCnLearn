package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-14 23:57
 */
public class Q2782 {
    public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        int categories = 1;
        for (int i = 1; i < n; i++) {
            boolean foundSameCategory = false;
            for (int j = 0; j < i && !foundSameCategory; j++) {
                if (categoryHandler.haveSameCategory(j, i)) {
                    foundSameCategory = true;
                }
            }
            if (!foundSameCategory) {
                categories++;
            }
        }
        return categories;
    }

    private static class CategoryHandler {
        public CategoryHandler(int[] categories) {

        }

        public boolean haveSameCategory(int a, int b){
            return  false;
        }
    }
}
