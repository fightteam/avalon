package org.fightteam.avalon.event.handler;

import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

/**
 * Created with IntelliJ IDEA.
 * User: excalibur
 * Date: 13-8-24
 * Time: 下午1:06
 * To change this template use File | Settings | File Templates.
 */
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @HandleBeforeCreate
    public void beforeCreate(User user){

    }
}
