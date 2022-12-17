package am.itspace.bagariocompanycommon.repository;

import am.itspace.bagariocompanycommon.entity.Order;
import am.itspace.bagariocompanycommon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}