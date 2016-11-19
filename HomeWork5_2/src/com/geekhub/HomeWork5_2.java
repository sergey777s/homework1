package com.geekhub;


import com.geekhub.Source.SourceLoader;

import java.util.Scanner;

public class HomeWork5_2 {
    public static void main(String[] args) throws TranslateException {
        String userLink = "";
        boolean passedLink = false;
        do {
            System.out.println("Enter link for translate:");
            Scanner scanner = new Scanner(System.in);
            userLink = scanner.nextLine();
            if (userLink.startsWith("http") || userLink.startsWith("ftp") || (userLink.charAt(1) == ':')) {
                passedLink = true;
            }
        } while (!passedLink == true);
        SourceLoader sourceLoader = new SourceLoader();
        sourceLoader.setLink(userLink);
        sourceLoader.chooseDirection();
        Translator translator = new Translator();
        System.out.println("Text for translate: " + translator.getTextForTranslate());
        System.out.println("Translated text: " + translator.translate());

    }
}
