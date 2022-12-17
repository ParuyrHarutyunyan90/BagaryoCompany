package am.itspace.bagariocompanyweb.controller;


import am.itspace.bagariocompanycommon.entity.Order;
import am.itspace.bagariocompanycommon.entity.Role;
import am.itspace.bagariocompanycommon.entity.User;
import am.itspace.bagariocompanycommon.security.CurrentUser;
import am.itspace.bagariocompanycommon.service.OrderService;
import am.itspace.bagariocompanycommon.service.UserService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @SneakyThrows
    @PostMapping("/register")
    public String register(@ModelAttribute User user) throws am.itspace.bagaryocompany.exception.DuplicateException, MessagingException {
        user.setRole(Role.USER);
        userService.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/myOrders")
    public String myOrdersPage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap){
        List<Order> myOrders = orderService.findAllByUser(currentUser.getUser());
        modelMap.addAttribute("myOrders", myOrders);
        return "tracking-order";
    }

}
