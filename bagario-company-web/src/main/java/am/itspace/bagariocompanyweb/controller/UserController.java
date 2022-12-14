package am.itspace.bagaryocompany.controller;

import am.itspace.bagaryocompany.entity.Order;
import am.itspace.bagaryocompany.entity.User;
import am.itspace.bagaryocompany.exception.DuplicateException;
import am.itspace.bagaryocompany.security.CurrentUser;
import am.itspace.bagaryocompany.service.OrderService;
import am.itspace.bagaryocompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final OrderService orderService;

    @GetMapping("/user/verify")
    public String verifyUser(@RequestParam("email") String email, @RequestParam("token") String token) throws Exception {
        userService.verifyUser(email, token);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) throws DuplicateException, MessagingException {
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/myOrders")
    public String myOrdersPage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap){
        List<Order> myOrders = orderService.findAllByUser(currentUser.getUser());
        modelMap.addAttribute("myOrders", myOrders);
        return "myOrders";
    }

}
