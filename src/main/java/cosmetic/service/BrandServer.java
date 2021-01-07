package cosmetic.service;

import cosmetic.entity.BrandEntity;
import cosmetic.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServer {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandEntity> findAll(){ return brandRepository.findAll();}

    public BrandEntity findOneById(String idBrand){ return brandRepository.findById(idBrand).get();}

    public void save (BrandEntity brandEntity) { brandRepository.save(brandEntity);}

    public void delete(String id){   brandRepository.deleteById(id);   }
}
