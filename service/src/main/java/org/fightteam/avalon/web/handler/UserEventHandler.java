package org.fightteam.avalon.web.handler;

import org.fightteam.join.auth.data.models.User;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

/**
 * User的event测试
 *
 * @author faith
 * @since 0.0.1
 */
@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    /**
     * POST前调用
     *
     * @param user
     */
    @HandleBeforeCreate
    public void HandleBeforeCreate(User user) {
        System.out.println("==========HandleBeforeCreate===========");
    }

    /**
     * PUT之前调用
     *
     * @param user
     */
    @HandleBeforeSave
    public void HandleBeforeSave(User user) {
        System.out.println("==========HandleBeforeSave===========");
    }

    /**
     * DELETE之前调用
     *
     * @param user
     */
    @HandleBeforeDelete
    public void HandleBeforeDelete(User user) {
        System.out.println("==========HandleBeforeDelete===========");
    }

    /**
     * POST后调用
     *
     * @param user
     */
    @HandleAfterCreate
    public void HandleAfterCreate(User user) {
        System.out.println("==========HandleAfterCreate===========");
    }

    /**
     * PUT之后调用
     *
     * @param user
     */
    @HandleAfterSave
    public void HandleAfterSave(User user) {
        System.out.println("==========HandleAfterSave===========");
    }


    /**
     * DELETE后调用
     *
     * @param user
     */
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


    @HandleBeforeLinkDelete
    public void HandleBeforeLinkDelete(User user) {
        System.out.println("==========HandleBeforeLinkDelete===========");
    }

    @HandleBeforeLinkSave
    public void HandleBeforeLinkSave(User user) {
        System.out.println("==========HandleBeforeLinkSave===========");
    }


}
