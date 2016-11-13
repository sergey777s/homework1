package com.geekhub;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by Sergey777s on 12.11.16.
 */
public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        System.out.println("Write name of task:");
        String name = scanner.nextLine();
        return name;
    }

    public String getCategory() {
        System.out.println("Write category:");
        String category = scanner.nextLine();
        return category;
    }

    public String[] getCategorys() {
        System.out.println("Write categorys:");
        String[] categorys = scanner.nextLine().split(" ");
        return categorys;
    }

    public LocalDateTime getDate() {
        System.out.println("Write day:");
        int day = scanner.nextInt();
        System.out.println("Write month:");
        int month = scanner.nextInt();
        System.out.println("Write year:");
        int year = scanner.nextInt();
        String category = scanner.nextLine();
        LocalDateTime date = LocalDateTime.of(year, month, day, 0, 0);
        return date;
    }
}
