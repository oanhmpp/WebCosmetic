package cosmetic.service;

import cosmetic.entity.DetailOrderEntity;
import cosmetic.repository.DetailOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailOrderService {
    @Autowired
    DetailOrderRepository detailOrderRepository;

    public List<DetailOrderEntity> findAll(){
        return detailOrderRepository.findAll();
    }

    public  List<DetailOrderEntity> findByIDOrder(Long id){
        return detailOrderRepository.findByOrder_IdOrder(id);
    }

    public void save(DetailOrderEntity detailOrderEntity){
        detailOrderRepository.save(detailOrderEntity);
    }
}
