package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-18 22:55
 */
public class Q527 {
    /**
     * 缩写
     */
    public String getAbbreviation(List<String> words, int index, int length) {
        //提取字符串
        String word = words.get(index);
        //缩写
        StringBuilder sb = new StringBuilder();
        if (length < word.length() - 2) {
            //字符叠加
            sb.append(word.substring(0, length)).append(word.length() - 1 - length).append(word.charAt(word.length() - 1));

        } else {
            //若缩写并不比原单词更短，则保留原样。
            sb.append(word);

        }
        //返回结果
        return sb.toString();

    }

    /**
     * 重合校正  若存在冲突，亦即多于一个单词有同样的缩写，则使用更长的前缀代替首字母，直到从单词到缩写的映射唯一。换而言之，最终的缩写必须只能映射到一个单词。
     *
     * @param abbrlist
     * @param words
     * @param indexlist
     * @param startindex
     */
    public void rectifyAbbreviation(List<String> abbrlist, List<String> words, List<Integer> indexlist, int startindex) {
        //没有重复
        if (indexlist.size() == 1) {
            //获取新的缩写
            String newabbr = getAbbreviation(words, indexlist.get(0), startindex);
            //更新
            abbrlist.set(indexlist.get(0), newabbr);
            return;
        }
        //abcde
        //a3e
        //a b2e
        //字符去重
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int index : indexlist) {
            //取得当前字符串的字符
            char c = words.get(index).charAt(startindex);
            if (map.containsKey(c)) {
                map.get(c).add(index);
            } else {
                //临时列表
                List<Integer> tempList = new ArrayList<>();
                //保存索引
                tempList.add(index);
                //压入保存
                map.put(c, tempList);

            }
        }
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            rectifyAbbreviation(abbrlist, words, entry.getValue(), startindex + 1);
        }


    }

    public List<String> wordsAbbreviation(List<String> words) {
        //即多于一个单词有同样的缩写，去重
        //哈希表去重
        Map<String, List<Integer>> map = new HashMap<>();
        //结果
        List<String> list = new ArrayList<>();
        //循环单词列表
        for (int i = 0; i < words.size(); i++) {
            String abbr = getAbbreviation(words, i, 1);
            //追加缩写列表
            list.add(abbr);
            //判断包含
            if (map.containsKey(abbr)) {
                //去重，保存所有的索引
                map.get(abbr).add(i);

            } else {
                //临时列表
                List<Integer> templist = new ArrayList<>();
                //保存索引
                templist.add(i);
                //压入保存
                map.put(abbr, templist);
            }
        }
        //循环遍历所有map
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            //抓取索引
            List<Integer> valuelist = entry.getValue();
            //存在重合
            if (valuelist.size() > 1) {
                //去重
                rectifyAbbreviation(list, words, valuelist, 0);
            }
        }
        //返回列表
        return list;
    }
}
