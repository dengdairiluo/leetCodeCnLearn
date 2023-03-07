package com.yuren.leetcodecnlearn.Q500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-23 23:04
 */
public class Q537 {
    public String complexNumberMultiply(String a, String b) {
        String[] stA = a.split("\\+");
        String[] stB = b.split("\\+");
        int num = 0;
        int numA = 0;
        int numB = 0;
        int numC = 0;
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < stA.length; i++) {
            int lenA = stA[i].length() - 1;
            for (int j = 0; j < stB.length; j++) {
                int lenB = stB[j].length() - 1;
                if (stA[i].charAt(lenA) == 'i' || stB[j].charAt(lenB) == 'i') {

                    if (stA[i].charAt(lenA) == 'i') {
                        numA = Integer.parseInt(stA[i].substring(0, lenA));
                    } else {
                        numA = Integer.parseInt(stA[i].substring(0, lenA + 1));
                    }

                    if (stB[j].charAt(lenB) == 'i') {
                        numB = Integer.parseInt(stB[j].substring(0, lenB));
                    } else {
                        numB = Integer.parseInt(stB[j].substring(0, lenB + 1));
                    }

                    numC = numB * numA;
                    if (stA[i].charAt(lenA) == 'i' && stB[j].charAt(lenB) == 'i') {
                        num = num + numC * (-1);
                    } else {
                        temp.add((numC + "i"));
                    }

                } else {
                    numA = Integer.parseInt(stA[i].substring(0, lenA + 1));
                    numB = Integer.parseInt(stB[j].substring(0, lenB + 1));
                    numC = numB * numA;
                    num = num + numC;
                }
            }
        }
        //计算虚部
        int curNum = 0;
        for (int i = 0; i < temp.size(); i++) {
            curNum += Integer.parseInt(temp.get(i).substring(0, temp.get(i).length() - 1));
        }

        return num +
                "+" +
                curNum +
                "i";
    }
}
