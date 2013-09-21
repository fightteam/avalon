package org.fightteam.avalon.rest.event.handler;

import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 *
 * @author excalibur
 * @since 0.0.1
 */
@Component
@RepositoryEventHandler(User.class)
@Validated
public class UserEventHandler {

    @HandleBeforeCreate
    public void beforeCreate(User user){


          System.out.println("******beforeCreate*******");
    }
    @HandleBeforeSave
    public void beforeSave (@Valid User user){
          System.out.println("******HandleBeforeSave *******");
    }

    @HandleAfterDelete
    public void handleAfterDelete(User user) {
        System.out.println("**********handleAfterDelete***********");
    }
}
