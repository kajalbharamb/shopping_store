package com.example.store.reponse;

public class ApiResponse {
    private String statusCode;
    private final String message;


    public ApiResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
