package org.fightteam.avalon.web.controller;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Controller
public class AppController implements ResourceProcessor<RepositoryLinksResource> {



    @Override
    public RepositoryLinksResource process(RepositoryLinksResource linksResource) {
        //Link link = new Link("login","login");
        linksResource.add(linkTo(LoginController.class).slash("login").withRel("login"));
        linksResource.add(linkTo(RegisterController.class).slash("register").withRel("register"));
        return linksResource;
    }
}
