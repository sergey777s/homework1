package HomeWork4_2;

import java.util.Scanner;

public class HomeWork4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[99];
        int wordsCount = 0;
        boolean error = false;
        do {
            error = false;
            System.out.println("enter words count:");
            if (scanner.hasNextInt()) {
                wordsCount = scanner.nextInt();
                scanner.nextLine();
                if (wordsCount < 1 || wordsCount > 99)
                    error = true;
            }
        } while (error);
        for (int i = 0; i < wordsCount; i++) {
            strings[i] = scanner.nextLine();
        }
        try {
            for (String currentString : strings) {
                if (currentString.length() <= 9) {
                    System.out.println(currentString);
                } else if (currentString.length() > 100) {
                    System.out.println("error: This word too big");
                } else {
                    System.out.print(currentString.charAt(0));
                    System.out.print(currentString.length() - 2);
                    System.out.println(currentString.charAt(currentString.length() - 1));
                }
            }
        } catch (NullPointerException e) {
        }
    }
}
