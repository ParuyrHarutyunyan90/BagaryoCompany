package am.itspace.bagaryocompany.controller;

import am.itspace.bagaryocompany.entity.Product;
import am.itspace.bagaryocompany.entity.Role;
import am.itspace.bagaryocompany.entity.User;
import am.itspace.bagaryocompany.exception.DuplicateException;
import am.itspace.bagaryocompany.security.CurrentUser;
import am.itspace.bagaryocompany.service.ProductService;
import am.itspace.bagaryocompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap) {
        List<Product> last20Products = productService.findLast20Products();
        modelMap.addAttribute("product", last20Products);
        return "index";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            if (user.getRole() == Role.MANAGER) {
                return "redirect:/admin";
            }else if(user.getRole() ==Role.USER){
                return "redirect:/";
            }
        }
        return "redirect:/";
    }
}
