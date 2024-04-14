package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-14 下午10:09
 */
public class Q2353 {

    private static class FoodWithRate {
        String food;
        int rate;
        String cuisine;//保存烹饪方式的映射

        public FoodWithRate(String f, String cuisine, int rate) {
            food = f;
            this.cuisine = cuisine;
            this.rate = rate;
        }
    }

    //保存各个烹饪方式中所有food的排序结果
    HashMap<String, TreeSet<FoodWithRate>> map = new HashMap<>();
    //对象索引
    HashMap<String, FoodWithRate> foodIndexMap = new HashMap<>();

    public Q2353(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String f = foods[i], c = cuisines[i];
            int rate = ratings[i];
            TreeSet<FoodWithRate> set = map.getOrDefault(c, new TreeSet<>((o1, o2) -> o1.rate != o2.rate ? o2.rate - o1.rate : o1.food.compareTo(o2.food)));
            FoodWithRate foodWithRate = new FoodWithRate(f, c, rate);
            //保存对象索引
            foodIndexMap.put(f, foodWithRate);
            //加入新food对象, 由TreeSet比较器来排序
            set.add(foodWithRate);
            map.put(c, set);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodWithRate legacyFood = foodIndexMap.get(food);
        TreeSet<FoodWithRate> foodWithRates = map.get(legacyFood.cuisine);//找烹饪方式
        foodWithRates.remove(legacyFood);//根据索引删除老节点
        FoodWithRate foodWithRate = new FoodWithRate(food, legacyFood.cuisine, newRating);
        foodIndexMap.put(food, foodWithRate);
        foodWithRates.add(foodWithRate);//加入新节点,由TreeSet比较器来排序
    }

    public String highestRated(String c) {
        TreeSet<FoodWithRate> foodWithRates = map.get(c);
        return foodWithRates.first().food;//找到最大值
    }
}
