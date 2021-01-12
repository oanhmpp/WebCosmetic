package cosmetic.repository;

import cosmetic.entity.ProductEntity;
import cosmetic.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<RoleEntity, Long> {
}
