package cosmetic.service;

import cosmetic.entity.CustomerEntity;
import cosmetic.entity.MyCustomerDetails;
import cosmetic.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIml implements UserDetailsService {
    @Autowired
    private CustomerRespository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity user = userRepository.getCustomerEntityByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyCustomerDetails(user);
    }
}
