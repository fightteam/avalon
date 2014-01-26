package org.fightteam.avalon.web.validator;

import org.fightteam.avalon.data.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 采用spring validator 方式验证
 *
 * @author faith
 * @since 0.0.1
 */
@Component("beforeSave")
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
