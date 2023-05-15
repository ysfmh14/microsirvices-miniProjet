package com.example.ProductService.service;

import com.example.ProductService.dto.RequestProductDto;
import com.example.ProductService.dto.ResponseProductDto;

import java.util.List;

public interface ProductService {
    List<ResponseProductDto> getProducts();
    ResponseProductDto addProduct(RequestProductDto productDto);
    ResponseProductDto updateProduct(RequestProductDto productDto);
    void deleteProductById(int productId);
    ResponseProductDto getProductById(int productId);
}
