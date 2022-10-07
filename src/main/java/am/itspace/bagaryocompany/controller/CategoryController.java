package am.itspace.bagaryocompany.controller;

import am.itspace.bagaryocompany.entity.Category;
import am.itspace.bagaryocompany.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String categoryPage(ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "category";
    }
}
