package org.fightteam.avalon.rest.validation;

import org.fightteam.avalon.core.entity.domain.User;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 * 创建User属性验证类
 *
 * 当在创建user时候验证信息完整性
 *
 * @author excalibur
 * @since 0.0.1
 */
@Component("beforeCreateUserValidator")
public class UserValidation implements Validator {
    @Autowired
    Validator validator;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("*********************");
        System.out.println(target);

        validator.validate(target,errors);

        System.out.println("**********56565***********");
        System.out.println(errors);
        //ValidationUtils.invokeValidator(validator,target,errors);
      // ValidationUtils.rejectIfEmpty(errors, "username", "not.blank");
       // ValidationUtils.rejectIfEmpty(errors, "password", "not.blank");
    }
}
