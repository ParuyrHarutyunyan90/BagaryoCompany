package am.itspace.bagariocompanyweb.controller;

import am.itspace.bagariocompanycommon.entity.Category;
import am.itspace.bagariocompanycommon.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    private String categoryPage(ModelMap modelMap) {
        List<Category> categories = categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        return "category";
    }
    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute Category category) {
        category.setDateSince(new Date());
        categoryService.save(category);
        return "redirect:/admin";
    }
}
