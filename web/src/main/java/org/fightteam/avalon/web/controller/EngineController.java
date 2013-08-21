package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.data.rest.webmvc.RestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created with IntelliJ IDEA.
 * User: excalibur
 * Date: 13-8-18
 * Time: 下午6:38
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class EngineController implements ResourceProcessor<RepositoryLinksResource> {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users")
    public HttpEntity<Resources<Resource<User>>> showUsersInProgress() {

        List<User> users = new ArrayList<User>();

        User user = new User("excalibur","123456",null);

        users.add(user);
        Resources<Resource<User>> userResources = Resources.wrap(users);
        userResources.add(linkTo(methodOn(EngineController.class).showUsersInProgress()).withSelfRel());

        return new ResponseEntity<Resources<Resource<User>>>(userResources, HttpStatus.OK);
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(linkTo(methodOn(EngineController.class).showUsersInProgress()).withRel("engine"));
        resource.add(linkTo(EngineController.class).slash("pages").withRel("page"));

        return resource;
    }
}
