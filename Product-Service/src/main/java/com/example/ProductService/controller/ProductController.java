package com.example.ProductService.controller;

import com.example.ProductService.dto.RequestProductDto;
import com.example.ProductService.dto.ResponseProductDto;
import com.example.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private  final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDto> getProductById(int productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ResponseProductDto> addProdcut(RequestProductDto productDto) {
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ResponseProductDto> updateProduct(RequestProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(productDto), HttpStatus.OK);
    }
    public ResponseEntity<?> deleteModule(int productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
