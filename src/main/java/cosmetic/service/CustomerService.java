package cosmetic.service;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    public List<CustomerEntity> findAll() {   return customerRespository.findAll();    }

    public CustomerEntity findOneById(Long id) { return customerRespository.findById(id).get();}

    public void save(CustomerEntity customer) {
        customerRespository.save(customer);
    }

    public void delete(Long id){
        customerRespository.deleteById(id);
    }
}
