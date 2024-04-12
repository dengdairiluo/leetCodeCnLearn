package com.yuren.leetcodecnlearn.Q1900;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-23 23:46
 */
public class Q1948 {
    private Folder root = new Folder();
    private Map<String, Integer> removeMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> list : paths) {
            Folder node = root;
            for (String folder : list) {
                if (!node.children.containsKey(folder)) node.children.put(folder, new Folder());
                node = node.children.get(folder);
            }
        }
        this.serialize(root);
        List<List<String>> list = new ArrayList<>();
        removeMap.put("", 1);
        this.generateAnswersRecursively(list, new ArrayList<>(), root);
        return list;
    }

    private String serialize(Folder folder) {
        if (folder.children.size() == 0) {
            folder.serialStr = "";
            return folder.serialStr;
        }
        StringBuilder builder = new StringBuilder();
        List<String> tempList = new ArrayList<>();
        for (Map.Entry<String, Folder> entry : folder.children.entrySet()) {
            builder.setLength(0);
            builder.append(entry.getKey()).append("(").append(serialize(entry.getValue())).append(")");
            tempList.add(builder.toString());
        }
        Collections.sort(tempList);
        builder.setLength(0);
        for (String str : tempList) builder.append(str);
        folder.serialStr = builder.toString();
        removeMap.put(folder.serialStr, removeMap.getOrDefault(folder.serialStr, 0) + 1);
        return folder.serialStr;
    }

    private void generateAnswersRecursively(List<List<String>> list, List<String> temp, Folder folder) {
        if (removeMap.get(folder.serialStr) > 1) return;
        if (temp.size() > 0) list.add(new ArrayList<>(temp));
        for (Map.Entry<String, Folder> entry : folder.children.entrySet()) {
            temp.add(entry.getKey());
            this.generateAnswersRecursively(list, temp, entry.getValue());
            temp.remove(temp.size() - 1);
        }
    }

    static class Folder {
        private String serialStr;
        private Map<String, Folder> children = new HashMap<>();

        public Folder() {

        }
    }
}
