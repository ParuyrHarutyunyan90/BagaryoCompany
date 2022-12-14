package am.itspace.bagariocompanyweb.controller;

import am.itspace.bagariocompanycommon.entity.Order;
import am.itspace.bagariocompanycommon.entity.Product;
import am.itspace.bagariocompanycommon.security.CurrentUser;
import am.itspace.bagariocompanycommon.service.OrderService;

import am.itspace.bagariocompanycommon.service.ProductService;
import am.itspace.bagariocompanycommon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/order/new")
    public String newOrder(@RequestParam("productId") int productId,
                           @AuthenticationPrincipal CurrentUser currentUser) {
        Optional<Product> byId = productService.findById(productId);
        if (byId.isEmpty()) {
            return "redirect:/";
        }
        Order order = Order.builder()
                .product(byId.get())
                .user(currentUser.getUser())
                .shipmentDeadline(new Date())
                .amount(byId.get().getPrice())
                .build();
        orderService.save(order);
        return "redirect:/myOrders";
    }

}
