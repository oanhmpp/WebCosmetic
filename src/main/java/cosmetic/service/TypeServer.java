package cosmetic.service;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.TypeEntity;
import cosmetic.repository.BrandRepository;
import cosmetic.repository.TypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServer {
    @Autowired
    private TypeRespository typeRespository;

    public List<TypeEntity> findAll(){ return typeRespository.findAll();}
}
