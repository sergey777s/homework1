package com.geekhub.Source;

import com.geekhub.TranslateException;

public class SourceLoader {
    private String link;

    public void setLink(String link) {
        this.link = link;
    }

    public void chooseDirection() throws TranslateException {
        if (link.startsWith("http")) {
            URLSourceProvider urlSourceProvider = new URLSourceProvider(link);
        }
        if (link.charAt(1) == ':') {
            FileSourceProvider fileSourceProvider = new FileSourceProvider(link);
        }
    }
}