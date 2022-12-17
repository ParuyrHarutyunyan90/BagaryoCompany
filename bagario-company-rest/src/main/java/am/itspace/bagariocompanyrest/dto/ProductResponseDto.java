package am.itspace.bagariocompanyrest.dto;

import am.itspace.bagariocompanyrest.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private int id;
    private String name;
    private int count;
    private double price;
    private double rating;
    private Category category;
}


