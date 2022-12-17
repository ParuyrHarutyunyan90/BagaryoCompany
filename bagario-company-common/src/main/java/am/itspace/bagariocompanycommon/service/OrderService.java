package am.itspace.bagariocompanycommon.service;

import am.itspace.bagariocompanycommon.entity.Order;
import am.itspace.bagariocompanycommon.entity.User;
import am.itspace.bagariocompanycommon.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAllByUser(User user) {

        return orderRepository.findAllByUser(user);
    }
}
