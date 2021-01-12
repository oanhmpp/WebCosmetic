package cosmetic.service;

import cosmetic.entity.CustomerEntity;
import cosmetic.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<CustomerEntity> findByEmail(String value) {
       return customerRespository.findByEmail(value);
    }

    public CustomerEntity findOneByEmail(String value){
        return customerRespository.findOneByEmail(value);
    }
}
