package cosmetic.service;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.TypeEntity;
import cosmetic.repository.BrandRepository;
import cosmetic.repository.TypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypeRespository typeRespository;

    public List<TypeEntity> findAll() {
        return typeRespository.findAll();
    }

    public Optional<TypeEntity> findOneById(Long idType) {
        return typeRespository.findById(idType);
    }

    public void save(TypeEntity typeEntity) {
        typeRespository.save(typeEntity);
    }

    public void delete(Long id) {
        typeRespository.deleteById(id);
    }

    public List<TypeEntity> findByIdIn(Long[] type) {
        return typeRespository.findByIdTypeIn(type);
    }
}
