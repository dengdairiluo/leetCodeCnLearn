package com.yuren.leetcodecnlearn.Q2500;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-11 22:14
 */
public class Q2590 {
    private int taskId;
    private final Map<Integer, Set<Integer>> userTasks;
    private final Map<Integer, Task> tasks;

    public Q2590() {
        taskId = 0;
        userTasks = new HashMap<>();
        tasks = new HashMap<>();
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        taskId++;
        userTasks.putIfAbsent(userId, new HashSet<>());
        userTasks.get(userId).add(taskId);
        Task task = new Task(taskId, taskDescription, dueDate, tags);
        tasks.put(taskId, task);
        return taskId;
    }

    public List<String> getAllTasks(int userId) {
        List<Task> tasksList = new ArrayList<>();
        Set<Integer> tasksSet = userTasks.getOrDefault(userId, new HashSet<>());
        for (int id : tasksSet) {
            Task task = tasks.get(id);
            tasksList.add(task);
        }
        Collections.sort(tasksList, Comparator.comparingInt(Task::getDueDate));
        List<String> descriptions = new ArrayList<>();
        for (Task task : tasksList) {
            descriptions.add(task.getDescription());
        }
        return descriptions;
    }

    public List<String> getTasksForTag(int userId, String tag) {
        List<Task> tasksList = new ArrayList<>();
        Set<Integer> tasksSet = userTasks.getOrDefault(userId, new HashSet<>());
        for (int id : tasksSet) {
            Task task = tasks.get(id);
            if (task.getTags().contains(tag)) {
                tasksList.add(task);
            }
        }
        Collections.sort(tasksList, Comparator.comparingInt(Task::getDueDate));
        List<String> descriptions = new ArrayList<>();
        for (Task task : tasksList) {
            descriptions.add(task.getDescription());
        }
        return descriptions;
    }

    public void completeTask(int userId, int taskId) {
        Set<Integer> tasksSet = userTasks.getOrDefault(userId, new HashSet<Integer>());
        if (tasksSet.contains(taskId) && tasks.containsKey(taskId)) {
            tasksSet.remove(taskId);
            tasks.remove(taskId);
        }
    }


    private static class Task {
        private final int id;
        private final String description;
        private final int dueDate;
        private final Set<String> tags;

        public Task(int id, String description, int dueDate, List<String> tags) {
            this.id = id;
            this.description = description;
            this.dueDate = dueDate;
            this.tags = new HashSet<>(tags);
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public int getDueDate() {
            return dueDate;
        }

        public Set<String> getTags() {
            return tags;
        }
    }
}
