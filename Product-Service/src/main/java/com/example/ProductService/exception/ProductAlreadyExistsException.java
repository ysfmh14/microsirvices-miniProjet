package com.example.ProductService.exception;

import com.example.ProductService.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ProductAlreadyExistsException extends ApiBasedException {

    public ProductAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
