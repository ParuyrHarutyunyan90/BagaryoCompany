package am.itspace.bagaryocompany.repository;

import am.itspace.bagaryocompany.entity.Order;
import am.itspace.bagaryocompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}