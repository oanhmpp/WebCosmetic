package cosmetic.service;

import cosmetic.entity.OrdersEntity;
import cosmetic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void save (OrdersEntity ordersEntity){
        orderRepository.save(ordersEntity);
    }
}
