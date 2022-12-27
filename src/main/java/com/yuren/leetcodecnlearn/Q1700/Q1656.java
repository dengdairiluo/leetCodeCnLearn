package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-03-19 22:42
 */
public class Q1656 {

    String[] stream;
    int ptr = 0;

    public Q1656(int n) {
        // 根据长度创建String数组保存值
        stream = new String[n];
    }

    public List<String> insert(int id, String value) {
        // id从1起始，所以减1
        stream[id - 1] = value;
        // 要返回的数组
        List<String> list = new ArrayList<>();
        // 从ptr开始，直到数组的末尾
        for (int i = ptr; i < stream.length; i++) {
            // 如果遇到流中的空值，跳出循环直接返回list
            if (stream[i] == null) {
                break;
            } else { // 如果该处不为空值，那么ptr就可以到这个地方，返回的list中也应包括这个值
                ptr++;
                list.add(stream[i]);
            }
        }
        return list;
    }

}
