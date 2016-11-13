package com.geekhub;

import java.time.LocalDateTime;
import java.util.*;

public class Tasker implements TaskManager {
    private Map<LocalDateTime, List<Task>> tasksByDate = new HashMap<>();

    public void add(LocalDateTime date, Task task) {
        List<Task> tasks = this.tasksByDate.get(date);
        if (tasks == null) {
            tasks = new ArrayList<>();
            tasksByDate.put(date, tasks);
        }
        tasks.add(task);
    }

    public void remove(LocalDateTime date) {
        for (LocalDateTime _date : tasksByDate.keySet()) {
            if (_date.equals(date)) {
                tasksByDate.remove(date);
            }
        }
    }

    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>();
        int i = 0;
        Task t;
        for (Map.Entry<LocalDateTime, List<Task>> curTaskEntry : tasksByDate.entrySet()) {
            List<Task> curTasks = curTaskEntry.getValue();
            for (Task curTask : curTasks) {
                categories.add(curTask.getCategory());
            }
            System.out.println("after " + tasksByDate);
        }

        return categories;
    }

    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> categorysWsTasks = new TreeMap<>();
        List<Task> tasksFromCurrentCategory = new ArrayList<>();
        for (String category : categories) {
            LocalDateTime currentDate = LocalDateTime.of(1, 1, 1, 1, 1);
            for (Map.Entry<LocalDateTime, List<Task>> tasks : tasksByDate.entrySet()) {
                for (Task task : tasks.getValue()) {
                    currentDate = tasks.getKey();
                    if (task.getCategory().equals(category)) {
                        tasksFromCurrentCategory.add(task);
                    }
                }
                categorysWsTasks.put(currentDate.toString(), tasksFromCurrentCategory);
            }
        }
        return categorysWsTasks;
    }

    public List<Task> getTasksByCategory(String category) {
        Map<String, List<Task>> tasksByCategory = getTasksByCategories(category);
        List<Task> tasksInCategory = new ArrayList<>();
        for (List<Task> tasks : tasksByCategory.values()) {
            Iterator<Task> everyTask = tasks.iterator();
            while (everyTask.hasNext()) {
                tasksInCategory.add(everyTask.next());
            }
        }
        return tasksInCategory;
    }

    public List<Task> getTasksForToday() {
        LocalDateTime date = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        List<Task> tasksForToday = new ArrayList<>();
        for (LocalDateTime _date : tasksByDate.keySet()) {
            if (_date.equals(date.withSecond(0).withNano(0))) {
                tasksForToday.addAll(tasksByDate.get(_date));
            }
        }
        return tasksForToday;
    }
}
