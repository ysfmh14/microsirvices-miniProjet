package com.example.ProductService.exception;

import com.example.ProductService.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ProductRequestIsNull extends ApiBasedException {

    public ProductRequestIsNull(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NO_CONTENT;
    }
}
