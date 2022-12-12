package am.itspace.bagaryocompany.service;

import am.itspace.bagaryocompany.entity.Product;
import am.itspace.bagaryocompany.repository.ProductRepository;
import am.itspace.bagaryocompany.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findLast20Products() {
        return productRepository.findTop20ByOrderByIdDesc();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);

    }

    public void removeById(int id) {
        productRepository.deleteById(id);
    }

}
