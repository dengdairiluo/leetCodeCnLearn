package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-29 20:23
 */
public class Q293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; ++i) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(currentState);
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                String str = sb.toString();
                ls.add(str);
            }
        }
        return ls;
    }
}
