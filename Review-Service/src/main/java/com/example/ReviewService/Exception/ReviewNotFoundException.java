package com.example.ReviewService.Exception;

import com.example.ReviewService.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ReviewNotFoundException extends ApiBasedException {
    public ReviewNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
