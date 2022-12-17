package am.itspace.bagariocompanycommon.service;

import am.itspace.bagariocompanycommon.entity.Product;
import am.itspace.bagariocompanycommon.repository.ProductRepository;

import am.itspace.bagariocompanycommon.repository.UserRepository;
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

    public void removeById(int id) {
        productRepository.deleteById(id);
    }

}
