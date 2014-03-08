package org.fightteam.avalon.web.handler;

import org.fightteam.join.auth.data.models.User;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @HandleAfterCreate
    public void HandleAfterCreate(User user) {
        System.out.println("==========HandleAfterCreate===========");
    }

    @HandleAfterDelete
    public void HandleAfterDelete(User user) {
        System.out.println("==========HandleAfterDelete===========");
    }

    @HandleAfterLinkDelete
    public void HandleAfterLinkDelete(User user) {
        System.out.println("==========HandleAfterLinkDelete===========");
    }

    @HandleAfterLinkSave
    public void HandleAfterLinkSave(User user) {
        System.out.println("==========HandleAfterLinkSave===========");
    }

    @HandleAfterSave
    public void HandleAfterSave(User user) {
        System.out.println("==========HandleAfterSave===========");
    }

    @HandleBeforeCreate
    public void HandleBeforeCreate(User user) {
        System.out.println("==========HandleBeforeCreate===========");
    }

    @HandleBeforeDelete
    public void HandleBeforeDelete(User user) {
        System.out.println("==========HandleBeforeDelete===========");
    }

    @HandleBeforeLinkDelete
    public void HandleBeforeLinkDelete(User user) {
        System.out.println("==========HandleBeforeLinkDelete===========");
    }

    @HandleBeforeLinkSave
    public void HandleBeforeLinkSave(User user) {
        System.out.println("==========HandleBeforeLinkSave===========");
    }

    @HandleBeforeSave
    public void HandleBeforeSave(User user) {
        System.out.println("==========HandleBeforeSave===========");
    }


}
