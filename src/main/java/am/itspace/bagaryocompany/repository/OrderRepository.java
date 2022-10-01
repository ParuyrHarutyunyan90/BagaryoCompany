package am.itspace.bagaryocompany.repository;

import am.itspace.bagaryocompany.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}