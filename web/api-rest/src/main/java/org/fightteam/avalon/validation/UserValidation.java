package org.fightteam.avalon.validation;

import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: excalibur
 * Date: 13-8-25
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
@Component("beforeCreateUserValidator")
public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("*************************");
        System.out.println(errors);
        ValidationUtils.rejectIfEmpty(errors, "username", "not.blank");
        ValidationUtils.rejectIfEmpty(errors, "password", "not.blank");
    }
}
