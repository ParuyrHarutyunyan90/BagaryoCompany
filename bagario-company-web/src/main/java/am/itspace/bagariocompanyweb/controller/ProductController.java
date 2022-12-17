package am.itspace.bagariocompanyweb.controller;

import am.itspace.bagariocompanycommon.entity.Product;
import am.itspace.bagariocompanycommon.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/singleProduct/{id}")
    public String bookSinglePage(@PathVariable("id") int id, ModelMap modelMap) {
        Optional<Product> byId = productService.findById(id);
        if (byId.isEmpty()) {
            return "redirect:/";
        }
        modelMap.addAttribute("product", byId.get());
        return "single-product";
    }
    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product){
        product.setRating(5);
        product.setDateSince(new Date());
        product.setRatingCount(3);
        productService.save(product);
        return "redirect:/admin";
    }
}
