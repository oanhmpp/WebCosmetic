package cosmetic.service;

import cosmetic.entity.ProductEntity;
import cosmetic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServer {

    // tu dong new productRepository
    @Autowired
    private ProductRepository productRepository ;

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity findOneById(String id) { return productRepository.findById(id).get();}

    public void save(ProductEntity product) {
        productRepository.save(product);
    }
}
