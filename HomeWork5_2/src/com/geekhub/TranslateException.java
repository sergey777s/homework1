package com.geekhub;

public class TranslateException extends Exception {
    private String errorCode = "Unknown_Exception";

    public TranslateException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    private static void processErrorCodes(TranslateException e) throws TranslateException {
        switch (e.getErrorCode()) {
            case "BAD_URL":
                System.out.println("URL address is invalid");
                throw e;
            case "FILE_NOT_FOUND":
                System.out.println("Your file not found");
                throw e;
            case "ERROR_WHILE_TRANSLATE":
                System.out.println("Error while translate");
                break;
            default:
                System.out.println("Unknown error " + e.getMessage());
                e.printStackTrace();
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
