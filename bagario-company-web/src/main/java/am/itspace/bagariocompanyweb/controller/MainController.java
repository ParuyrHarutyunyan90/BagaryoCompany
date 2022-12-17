package am.itspace.bagariocompanyweb.controller;


import am.itspace.bagariocompanycommon.entity.Product;
import am.itspace.bagariocompanycommon.entity.Role;
import am.itspace.bagariocompanycommon.entity.User;
import am.itspace.bagariocompanycommon.security.CurrentUser;
import am.itspace.bagariocompanycommon.service.ProductService;
import am.itspace.bagariocompanycommon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
