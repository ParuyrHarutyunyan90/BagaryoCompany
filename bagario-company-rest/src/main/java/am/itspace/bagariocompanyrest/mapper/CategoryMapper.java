package am.itspace.bagariocompanyrest.mapper;

import am.itspace.bagariocompanyrest.dto.CategoryResponseDto;
import am.itspace.bagariocompanyrest.dto.CreateCategoryDto;
import am.itspace.bagariocompanyrest.model.Category;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CreateCategoryDto createCategoryDto);

    CategoryResponseDto map(Category category);

    List<CategoryResponseDto> map(List<Category> categoryList);
}
