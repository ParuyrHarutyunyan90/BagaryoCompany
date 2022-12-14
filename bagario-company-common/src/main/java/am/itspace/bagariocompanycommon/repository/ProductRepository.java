package am.itspace.bagaryocompany.repository;

import am.itspace.bagaryocompany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findTop20ByOrderByIdDesc();
}
