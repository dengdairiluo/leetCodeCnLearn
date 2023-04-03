package com.yuren.leetcodecnlearn.Q1400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-26 23:50
 */
public class Q1487 {

    private static final int BRACKET_HASH = 31 * '(';
    /**
     * POW_31[n] == 31^n
     */
    private static final int[] POW_31 = new int[5];
    /**
     * HASH[n]代表第n（最低位为1）位数为9时贡献的hash值
     */
    private static final int[] HASH = new int[4];

    static {
        POW_31[0] = 1;
        for (int i = 1; i < POW_31.length; i++) {
            HASH[i - 1] = (POW_31[i] = POW_31[i - 1] * 31) * 9;
        }
    }

    /**
     * 入参
     */
    private String[] names;
    /**
     * **射：入参元素的hashcode -> 当前序列号（序列号格式：按16进制看，低5位分别对应10进制序列号的5位数，第6位存储10进制表示的位数）
     */
    private Map<Integer, Integer> map;

    public String[] getFolderNames(String[] names) {
        this.names = names;
        map = new HashMap<>(((names.length << 2) + 2) / 3);
        for (int i = 0; i < names.length; i++) {
            process(i);
        }
        return names;
    }

    /**
     * 对names[i]进行处理
     *
     * @param i 下标
     */
    private void process(int i) {
        int key = names[i].hashCode();
        Integer seq = map.putIfAbsent(key, 0);
        if (seq == null) {
            return;
        }

        // 获取下一个序列号
        seq = nextSeq(seq, POW_31[2] * key + BRACKET_HASH);
        // 在名称后增加“(序列号)”生成新名称
        names[i] = genName(names[i], seq);
        // 更新***射
        map.put(key, seq);
    }

    /**
     * 获取下一个序列号
     *
     * @param seq  当前序列号
     * @param hash 31 * (名称 + '(').hashCode()
     * @return 下一个序列号
     */
    private int nextSeq(int seq, int hash) {
        // 根据当前序列号初始化hash
        if (seq == 0) {
            seq = 0x100001;
            hash = 31 * (hash + '1');
            if (map.putIfAbsent(hash + ')', 0) == null) {
                return seq;
            }
        } else {
            for (int len = seq >>> 20; --len >= 0; ) {
                hash = 31 * (hash + '0' + (seq >>> (len << 2) & 0xf));
            }
        }
        // 递增序列号直至找不到同名文件
        do {
            if ((seq & 0xf) != 9) {
                // 不进位
                ++seq;
                hash += 31;
            } else {
                // 进位
                int n = 0;
                do {
                    hash -= HASH[n];
                } while ((seq >>> (++n << 2) & 0xf) == 9);
                if (n == seq >>> 20) {
                    // 位数+1
                    seq += 0x100000;
                    hash = 31 * (hash + '1' * POW_31[n]);
                } else {
                    // 位数不变
                    hash += POW_31[n + 1];
                }
                // 高位加1，低位归0
                seq = seq + (1 << (n << 2)) & -1 << (n << 2);
            }
        } while (map.putIfAbsent(hash + ')', 0) != null);
        return seq;
    }

    /**
     * 在名称后增加“(序列号)”生成新名称
     *
     * @param name 输入名称
     * @param seq  序列号
     * @return 新名称
     */
    private String genName(String name, int seq) {
        int len = seq >>> 20;
        char[] value = new char[name.length() + len + 2];
        name.getChars(0, name.length(), value, 0);
        value[name.length()] = '(';
        value[value.length - 1] = ')';
        for (int base = value.length - 2; --len >= 0; ) {
            value[base - len] = (char) ('0' + (seq >>> (len << 2) & 0xf));
        }
        return new String(value);
    }
}
