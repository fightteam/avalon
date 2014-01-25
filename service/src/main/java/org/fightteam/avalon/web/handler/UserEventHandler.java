package org.fightteam.avalon.web.handler;

import org.fightteam.avalon.data.models.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
//@RepositoryEventHandler
public class UserEventHandler {
   // @HandleBeforeCreate
    public void handlePersonSave(User user){
        System.out.println("--------------------");
    }
}
