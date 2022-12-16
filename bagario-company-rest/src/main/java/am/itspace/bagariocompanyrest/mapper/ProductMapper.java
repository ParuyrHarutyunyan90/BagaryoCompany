package am.itspace.bagariocompanyrest.mapper;

import am.itspace.bagariocompanyrest.dto.CreateProductDto;
import am.itspace.bagariocompanyrest.dto.ProductResponseDto;
import am.itspace.bagariocompanyrest.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(CreateProductDto createProductDto);

    ProductResponseDto map(Product product);

    List<ProductResponseDto> map(List<Product> productList);
}
