package am.itspace.bagaryocompany.repository;

import am.itspace.bagaryocompany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
