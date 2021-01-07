package cosmetic.repository;

import cosmetic.entity.BrandEntity;
import cosmetic.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRespository extends JpaRepository<TypeEntity, Long> {

}