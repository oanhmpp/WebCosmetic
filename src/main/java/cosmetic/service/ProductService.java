package cosmetic.service;

import cosmetic.entity.ProductEntity;
import cosmetic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // tu dong new productRepository
    @Autowired
    private ProductRepository productRepository ;

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity findOneById(Long id) { return productRepository.findById(id).get();}

    public void save(ProductEntity product) {
        productRepository.save(product);
    }

    public void delete(Long idProduct){
        productRepository.deleteById(idProduct);
    }

}
