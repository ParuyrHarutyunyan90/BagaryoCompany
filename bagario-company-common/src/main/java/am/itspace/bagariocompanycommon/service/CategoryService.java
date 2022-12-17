package am.itspace.bagariocompanycommon.service;

import am.itspace.bagariocompanycommon.entity.Category;
import am.itspace.bagariocompanycommon.repository.CategoryRepository;
import am.itspace.bagariocompanycommon.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
}
