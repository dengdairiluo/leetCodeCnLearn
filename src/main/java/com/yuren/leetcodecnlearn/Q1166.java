package com.yuren.leetcodecnlearn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-22 23:26
 */
public class Q1166 {

    // 文件路径
    private final Map<String, Integer> fileMap;

    public Q1166() {
        fileMap = new HashMap<>();
        // 缓存根节点路径
        fileMap.put("", -1);
    }

    public boolean createPath(String path, int value) {
        // 没有删除的文件的情况，path只要存在，就一直存在
        if (fileMap.containsKey(path)) {
            // 文件已经存在了，返回false
            return false;
        }
        // 获取父路径
        int lastIndex = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastIndex);
        // 父路径不存在，则返回false
        if (!fileMap.containsKey(parentPath)) {
            return false;
        }
        // 文件记录
        fileMap.put(path, value);
        return true;
    }

    public int get(String path) {
        // 获取文件的值，不存在就是-1
        return fileMap.getOrDefault(path, -1);
    }
}
