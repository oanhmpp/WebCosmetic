package cosmetic.until;

import cosmetic.entity.MyCustomerDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtil {
    public static   MyCustomerDetails getPrincipal() {
        // de goi ten nguoi dung hien hanh
        try {
            return (MyCustomerDetails) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }


}
