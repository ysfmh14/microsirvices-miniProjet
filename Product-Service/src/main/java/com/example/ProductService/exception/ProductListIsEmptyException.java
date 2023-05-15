package com.example.ProductService.exception;

import com.example.ProductService.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ProductListIsEmptyException extends ApiBasedException {
    public ProductListIsEmptyException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
