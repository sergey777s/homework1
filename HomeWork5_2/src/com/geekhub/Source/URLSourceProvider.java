package com.geekhub.Source;

import com.geekhub.TranslateException;
import com.geekhub.Translator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLSourceProvider {

    public URLSourceProvider(String link) throws TranslateException {
        try {
            URL url = new URL(link);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputTextLine;
            String finalText = "";
            while ((inputTextLine = bufferedReader.readLine()) != null) {
                finalText += inputTextLine;
            }
            Translator translator = new Translator();
            translator.setTextForTranslate(finalText);
        } catch (MalformedURLException e) {
            throw new TranslateException(e.getMessage(), "BAD_URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
