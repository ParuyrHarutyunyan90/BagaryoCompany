package am.itspace.bagaryocompany.controller;

import am.itspace.bagaryocompany.entity.Product;
import am.itspace.bagaryocompany.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/book/{id}")
    public String bookSinglePage(@PathVariable("id") int id, ModelMap modelMap) {
        Optional<Product> byId = productService.findById(id);
        if (byId.isEmpty()) {
            return "redirect:/";
        }
        modelMap.addAttribute("product", byId.get());
        return "singleProduct";
    }
}
