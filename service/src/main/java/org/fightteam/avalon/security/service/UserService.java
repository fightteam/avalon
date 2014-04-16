package org.fightteam.avalon.security.service;

import org.fightteam.avalon.data.models.Consumer;
import org.fightteam.avalon.security.data.models.User;

/**
 *
 * 用户业务逻辑接口
 * @author excalibur
 * @since 0.0.1
 */
public interface UserService {

    boolean isUsernameExists(String username);

    boolean isEmailExists(String email);

    Consumer registerUser(Consumer consumer);
}