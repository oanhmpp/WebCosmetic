package cosmetic.validator;

import cosmetic.entity.CustomerEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidate implements Validator {
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return clazz.equals(CustomerEntity.class);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        CustomerEntity customerEntity = (CustomerEntity) target;
        checkMail(customerEntity.getEmail(),errors);
        checkPasswd(customerEntity.getPassword(),customerEntity.getRePass(),errors);
    }

    public void validateAdmin(Object target, Errors errors) {
        CustomerEntity customerEntity = (CustomerEntity) target;
        checkMail(customerEntity.getEmail(),errors);
        System.out.println("checked");
    }


    public void validateExist(Object target, Errors errors,boolean isEmty) {
        // TODO Auto-generated method stub
        CustomerEntity thanhVien = (CustomerEntity) target;
        // de empty hay !empty cung luu khi email trung nhau
        if (!isEmty) {
            System.out.println("da ton tai");
            errors.rejectValue("email", "email.existed");
        } else {
            System.out.println("k ton tai");
        }
    }

    public void checkPasswd(String matkhau, String nhapLaiMK, Errors errors) {
        // TODO Auto-generated method stub
        if(matkhau.isEmpty()||nhapLaiMK.isEmpty()) {
            System.out.println("notnull");
            errors.rejectValue("password", "input.null");
            errors.rejectValue("rePass", "input.null");
        }
        else if(matkhau.length()<8) {
            System.out.println("size");
            errors.rejectValue("password", "passwd.size");
            errors.rejectValue("rePass", "passwd.size");
        }
        else if(!matkhau.equals(nhapLaiMK)){
            System.out.println("else "+matkhau+"v"+nhapLaiMK);
            errors.rejectValue("rePass", "passwd.notEqual.repasswd");}
    }

    public void checkMail(String email,Errors errors) {
        // TODO Auto-generated method stub
        if(email.isEmpty())
            errors.rejectValue("email", "input.null");
        else if(!email.contains("@"))
            errors.rejectValue("email", "email.notContrain@");
    }

}
