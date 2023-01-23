package com.example.store.reponse;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ApiResponse {
    private int statusCode;
    private  String message;
    private List<Object> details;

    public ApiResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ApiResponse(int statusCode, String message, List<Object> details) {
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
