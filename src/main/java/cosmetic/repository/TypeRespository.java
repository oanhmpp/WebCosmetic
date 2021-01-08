package cosmetic.repository;

import cosmetic.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRespository extends JpaRepository<TypeEntity, Long> {
    List<TypeEntity> findByIdTypeIn(Long[] id);
}