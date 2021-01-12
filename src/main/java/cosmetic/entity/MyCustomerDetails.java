package cosmetic.entity;

import cosmetic.entity.CustomerEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data

// goi o dau cung duoc <security:authentication property="principal.customer.nameCustomer"/>
public class MyCustomerDetails implements UserDetails {

    private final CustomerEntity customer;

    public MyCustomerDetails(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customer.getRoleEntityList().get(0).getNameRole());
        return Collections.singletonList(authority);
    }

    public boolean isAdmin(){
        for (int i =0; i < customer.getRoleEntityList().size();i++){
            if(customer.getRoleEntityList().get(i).getIdRole() == 1){
           return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
