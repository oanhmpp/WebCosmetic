package cosmetic.service;

import cosmetic.entity.DetailProductEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    // tu dong new productRepository
    @Autowired
    private ProductDetailRepository productDetailRepository ;

    public List<DetailProductEntity> findAll() {
        return productDetailRepository.findAll();
    }

    public DetailProductEntity findOneById(Long id) { return productDetailRepository.findById(id).get();}

    public void save(DetailProductEntity product) {
        productDetailRepository.save(product);
    }

    public void delete(Long id){
        productDetailRepository.deleteById(id);
    }

}
