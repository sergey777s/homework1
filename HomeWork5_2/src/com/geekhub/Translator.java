package com.geekhub;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {
    private static String textForTranslate = "";

    public static String translate(String input) throws IOException {
        String urlOfYandex = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20161118T113759Z.4ffec10b6b1472e4.44dc8f4934906d0c9d2956827f5f8430aade5fd8";
        URL url = new URL(urlOfYandex);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8") + "&lang=en-ru");

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");
        String translated = json.substring(start + 2, end - 1);
        return translated;
    }

    public String getTextForTranslate() {
        return textForTranslate;
    }

    public void setTextForTranslate(String textForTranslate) {
        this.textForTranslate = textForTranslate;
    }

    public String translate() throws TranslateException {
        try {
            return translate(textForTranslate);
        } catch (IOException e) {
            throw new TranslateException(e.getMessage(), "ERROR_WHILE_TRANSLATE");
        }
    }
}
