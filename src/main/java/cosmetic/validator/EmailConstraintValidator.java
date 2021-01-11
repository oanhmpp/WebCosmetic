package cosmetic.validator;

import cosmetic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<Exist, String> {

@Autowired
CustomerService service;
public boolean isValid(String value, ConstraintValidatorContext context){

		if(service.findByEmail(value).isEmpty())
		return true;
		return false;
		}
		}