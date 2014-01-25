package org.fightteam.avalon.web.handler;

import org.fightteam.avalon.data.models.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Component
@RepositoryEventHandler
public class UserEventHandler {
   @HandleBeforeCreate(User.class)
    public void handlePersonSave(User user){
        System.out.println("--------------------");
       user.setUsername("excalibur");
    }
}
