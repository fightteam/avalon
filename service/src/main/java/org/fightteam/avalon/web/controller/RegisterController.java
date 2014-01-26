package org.fightteam.avalon.web.controller;

import org.fightteam.avalon.data.models.User;
import org.fightteam.avalon.web.common.Routers;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RegisterController implements ResourceProcessor<RepositoryLinksResource> {



    @RequestMapping(value = Routers.register, method = RequestMethod.POST)
    public HttpEntity<Resource<User>> register(User user){
        HttpEntity<Resource<User>> httpEntity = new ResponseEntity<Resource<User>>(HttpStatus.NOT_FOUND);
        return httpEntity;
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource linksResource) {
        return linksResource;
    }
}
