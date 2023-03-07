package com.yuren.leetcodecnlearn.Q700;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-22 22:34
 */
public class Q736 {
    char[] ex;
    int len;
    int index;
    public int evaluate(String expression) {
        ex = expression.toCharArray();
        len = ex.length;
        index = 1;
        return process(new HashMap<>());
    }
    public int process(Map<String, Integer> map) {
        if (ex[index] == 'l') {
            index += 4;
            return let(map);
        } else if (ex[index] == 'a') {
            index += 4;
            return add(map);
        } else {
            index += 5;
            return mult(map);
        }
    }
    public void updateMap(Map<String, Integer> map, Map<String, Integer> map1) {
        for (String s : map1.keySet()) {
            if (!map.containsKey(s)) {
                map.put(s, map1.get(s));
            }
        }
    }
    public int let(Map<String, Integer> map1) {
        String variate = "";
        int cur = 0;
        boolean isVariate = false;
        Map<String, Integer> map = new HashMap<>();
        updateMap(map, map1);
        while (index < len) {
            if (ex[index] == ')') {
                index++;
                if (isVariate) {
                    return map.get(variate);
                } else {
                    return cur;
                }
            } else if (ex[index] == ' ') {
                if (!isVariate) {
                    map.put(variate, cur);
                }
                index++;
            } else if (ex[index] == '(') {
                index++;
                isVariate = false;
                cur = process(map);
            } else {
                if (isLower(ex[index])) {
                    if (isVariate) {
                        isVariate = false;
                        cur = map.get(getVariate());
                    } else {
                        isVariate = true;
                        variate = getVariate();
                    }
                } else {
                    isVariate = false;
                    cur = getNum();
                }
            }
        }
        return 0;
    }
    public int add(Map<String, Integer> map) {
        int xVal = 0;
        int yVal = 0;
        boolean isX = true;
        while (index < len) {
            if (ex[index] == '(') {
                index++;
                if (isX) {
                    xVal = process(map);
                } else {
                    yVal = process(map);
                }
            } else if (ex[index] == ')') {
                index++;
                return xVal + yVal;
            } else if (ex[index] == ' ') {
                index++;
                isX = false;
            } else {
                if (isLower(ex[index])) {
                    if (isX) {
                        xVal = map.get(getVariate());
                    } else {
                        yVal = map.get(getVariate());
                    }
                } else {
                    if (isX) {
                        xVal = getNum();
                    } else {
                        yVal = getNum();
                    }
                }
            }
        }
        return 0;
    }
    public int mult(Map<String, Integer> map) {
        int xVal = 0;
        int yVal = 0;
        boolean isX = true;
        while (index < len) {
            if (ex[index] == '(') {
                index++;
                if (isX) {
                    xVal = process(map);
                } else {
                    yVal = process(map);
                }
            } else if (ex[index] == ')') {
                index++;
                return xVal * yVal;
            } else if (ex[index] == ' ') {
                index++;
                isX = false;
            } else {
                if (isLower(ex[index])) {
                    if (isX) {
                        xVal = map.get(getVariate());
                    } else {
                        yVal = map.get(getVariate());
                    }
                } else {
                    if (isX) {
                        xVal = getNum();
                    } else {
                        yVal = getNum();
                    }
                }
            }
        }
        return 0;
    }
    public String getVariate() {
        StringBuilder sb = new StringBuilder();
        while (index < len && (isDigit(ex[index]) || isLower(ex[index]))) {
            sb.append(ex[index++]);
        }
        return sb.toString();
    }
    public int getNum() {
        boolean isNeg = false;
        int ans = 0;
        if (ex[index] == '-') {
            isNeg = true;
            index++;
        }
        while (index < len && isDigit(ex[index])) {
            ans = ans * 10 + ex[index++] - '0';
        }
        return isNeg ? -ans : ans;
    }
    public boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
