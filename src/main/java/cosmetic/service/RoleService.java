package cosmetic.service;

import cosmetic.entity.RoleEntity;
import cosmetic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService  {
    @Autowired
    RoleRepository roleRepository;

//    public List<RoleEntity> findById(Long id) {
////        return roleRepository.findById(id);
//    }
}
