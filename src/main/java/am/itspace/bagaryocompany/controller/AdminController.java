package am.itspace.bagaryocompany.controller;

import am.itspace.bagaryocompany.entity.Product;
import am.itspace.bagaryocompany.service.OrderService;
import am.itspace.bagaryocompany.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;

    private final OrderService orderService;

    @GetMapping
    public String adminPage(ModelMap modelMap) {
        List<Product> productList = productService.findAll();
        modelMap.addAttribute("products");
        return "/admin/admin";
    }

    @GetMapping("/product/add")
    public String addProductPage() {
        return "admin";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/admin";
    }

    @GetMapping("/product/edit")
    public String productEdit(@RequestParam("productId") int id, ModelMap modelMap) {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("product", product.get());
        return "admin/editProduct";
    }

    @PostMapping("/product/edit")
    public String editBook(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/admin";
    }

    @GetMapping("/product/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
       productService.removeById(id);
        return "redirect:/admin";
    }

    @GetMapping("/allOrders")
    public String allOrdersPage(ModelMap modelMap){
        modelMap.addAttribute("orders", orderService.findAll());
        return "admin/adminOrders";
    }
}
