package cosmetic.Validate;

import cosmetic.entity.CustomerEntity;
import cosmetic.service.CustomerService;
import cosmetic.utils.SpringUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;


public class Validate implements Validator {
    CustomerService userService = SpringUtil.ctx.getBean(CustomerService.class);
    //dinh dang email
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(CustomerEntity.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerEntity userEntity= (CustomerEntity) target;
        if(userEntity.getEmail().equals("")){
            errors.rejectValue("email","register.null");
        }else if (!VALID_EMAIL_ADDRESS_REGEX.matcher(userEntity.getEmail()).find()){
            errors.rejectValue("email","reagister.email");
        }
//        else if (userService.checkEmail(userEntity.getEmail())){
//            errors.rejectValue("email","register.exist");
//        }
        if (userEntity.getPassword().equals("")){
            errors.rejectValue("password","register.null");
        }else if(userEntity.getPassword().length()<8){
            errors.rejectValue("password","register.pass");
        }
        if (userEntity.getNameCustomer().equals("")){
            errors.rejectValue("name","register.null");
        }

    }
}
