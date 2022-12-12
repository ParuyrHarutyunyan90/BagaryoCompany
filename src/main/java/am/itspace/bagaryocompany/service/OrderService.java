package am.itspace.bagaryocompany.service;

import am.itspace.bagaryocompany.entity.Order;
import am.itspace.bagaryocompany.entity.User;
import am.itspace.bagaryocompany.repository.OrderRepository;
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
