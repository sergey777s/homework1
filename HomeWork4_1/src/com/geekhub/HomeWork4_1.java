package com.geekhub;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeWork4_1 {
    public static void main(String[] args) {
        Tasker tasker = new Tasker();
        Task task;
        String category;
        String name;
        UserInput userInput = new UserInput();
        int userAnswer;
        LocalDateTime date;
        boolean next = false, error = false;
        Scanner scanner = new Scanner(System.in);

        do {
            next = false;
            error = false;
            System.out.println("Select action:");
            System.out.println("1. Add new task");
            System.out.println("2. Remove task by date");
            System.out.println("3. Get categorys");
            System.out.println("4. Get tasks by categorys");
            System.out.println("5. Get tasks by category");
            System.out.println("6. Get tasks for today");
            System.out.println("7. For exit");
            userAnswer = scanner.nextInt();
            switch (userAnswer) {
                case 1:
                    task = new Task(userInput.getName(), userInput.getCategory());
                    tasker.add(userInput.getDate(), task);
                    next = true;
                    break;
                case 2:
                    tasker.remove(userInput.getDate());
                    next = true;
                    break;
                case 3:
                    System.out.println(tasker.getCategories().toString());
                    next = true;
                    break;
                case 4:
                    System.out.println(tasker.getTasksByCategories(userInput.getCategorys()));
                    next = true;
                    break;
                case 5:
                    System.out.println(tasker.getTasksByCategory(userInput.getCategory()));
                    next = true;
                    break;
                case 6:
                    System.out.println(tasker.getTasksForToday());
                    next = true;
                    break;
                case 7:
                    break;
                default:
                    error = true;


            }
        } while (error || next);

    }
}
