package cosmetic.until;

import cosmetic.entity.MyCustomerDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUntil {
    public  MyCustomerDetails getPrincipal() {
        try {
            return (MyCustomerDetails) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
