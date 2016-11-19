package com.geekhub.Source;

import com.geekhub.TranslateException;
import com.geekhub.Translator;

import java.io.*;

public class FileSourceProvider {
    public FileSourceProvider(String link) throws TranslateException {
        File file = new File(link);
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                char[] buffer = new char[(int) file.length()];
                fileReader.read(buffer);
                Translator translator = new Translator();
                translator.setTextForTranslate(new String(buffer));
            } catch (FileNotFoundException e) {
                throw new TranslateException(e.getMessage(), "FILE_NOT_FOUND");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("File not exist");
    }
}
