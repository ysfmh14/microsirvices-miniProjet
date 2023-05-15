package com.example.ProductService.mapper;

import com.example.ProductService.dto.RequestProductDto;
import com.example.ProductService.dto.ResponseProductDto;
import com.example.ProductService.entity.Product;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Service
public interface ProductMapper {
    ResponseProductDto modelToDto(Product product);
    List<ResponseProductDto> modelToDtos(List<Product> products);
    Product dtoToModule(RequestProductDto requestProductDto);
}
