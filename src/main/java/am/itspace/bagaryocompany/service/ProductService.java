package am.itspace.bagaryocompany.service;

import am.itspace.bagaryocompany.entity.Product;
import am.itspace.bagaryocompany.repository.ProductRepository;
import am.itspace.bagaryocompany.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
//    public Product findById(int id) {
//        log.info("Find by email user");
//        return productRepository.findById(id).orElseThrow(() -> {
//            log.error("User with email: {} not found", id);
//            throw new ProductNotFoundException("User with email: ");
//        });
//    }

    public void removeById(int id) {
        productRepository.deleteById(id);
    }

}
