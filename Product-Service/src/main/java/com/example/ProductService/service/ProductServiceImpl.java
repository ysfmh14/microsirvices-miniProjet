package com.example.ProductService.service;

import com.example.ProductService.dao.ProductDao;
import com.example.ProductService.dto.RequestProductDto;
import com.example.ProductService.dto.ResponseProductDto;
import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.ProductAlreadyExistsException;
import com.example.ProductService.exception.ProductListIsEmptyException;
import com.example.ProductService.exception.ProductNotFoundException;
import com.example.ProductService.exception.ProductRequestIsNull;
import com.example.ProductService.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{
    private  final ProductDao productDao;
    private final ProductMapper productMapper;

    @Override
    public List<ResponseProductDto> getProducts() {
        List<Product> products= productDao.findAll();
        List<ResponseProductDto> responseProducyDTOS=productMapper.modelToDtos(products);
        if(responseProducyDTOS.isEmpty()) throw  new ProductListIsEmptyException("The list is empty");
        return responseProducyDTOS;
    }
    public ResponseProductDto entityResponseProductDto(RequestProductDto productDto){
        ResponseProductDto responseProductDto=productMapper.modelToDto(productDao.save(productMapper.dtoToModule(productDto)));
        if (responseProductDto==null) throw new ProductRequestIsNull("The request is null, is doesn't contain any content");
        return  responseProductDto;
    }

    @Override
    public ResponseProductDto addProduct(RequestProductDto productDto) {
        if (productDao.existsById(productDto.getProductId()))
            throw  new ProductAlreadyExistsException(String.format("The product with name %s is already exists",productDto.getProductId()));
        return entityResponseProductDto(productDto);
    }

    @Override
    public ResponseProductDto updateProduct(RequestProductDto productDto) {
        return entityResponseProductDto(productDto);
    }

    @Override
    public void deleteProductById(int productId) {
        productDao.deleteById(productId);
    }

    @Override
    public ResponseProductDto getProductById(int productId) {
        Product product=productDao.findById(productId).orElseThrow(()->
                new ProductNotFoundException(String.format("the product with id %d not exist.", productId)));
        return productMapper.modelToDto(product);
    }
}
