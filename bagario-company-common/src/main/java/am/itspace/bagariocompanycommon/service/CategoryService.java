package am.itspace.bagaryocompany.service;

import am.itspace.bagaryocompany.entity.Category;
import am.itspace.bagaryocompany.repository.CategoryRepository;
import am.itspace.bagaryocompany.repository.ProductRepository;
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
}
