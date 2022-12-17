package am.itspace.bagariocompanyrest.dto;

import am.itspace.bagariocompanyrest.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String title;
    private int count;
    private double price;
    private Category category;
}
