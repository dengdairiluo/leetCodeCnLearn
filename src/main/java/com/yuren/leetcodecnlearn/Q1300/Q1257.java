package com.yuren.leetcodecnlearn.Q1300;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-06 00:03
 */
public class Q1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        int n = regions.size();
        for (int i = n - 1; i >= 0; i--) {
            List<String> region = regions.get(i);
            if (region.contains(region1)) {
                region1 = region.get(0);
            }
            if (region.contains(region2)) {
                region2 = region.get(0);
            }
            if (region1.equals(region2)) {
                break;
            }
        }
        return region1;
    }
}
