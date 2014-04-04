package org.fightteam.avalon.web.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Controller;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * 首页开放链接
 *
 * 会根据用户权限列出
 *
 * 也会给予游客对应的链接
 *
 * @author faith
 * @since 0.0.1
 */
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AppController implements ResourceProcessor<RepositoryLinksResource> {



    @Override
    public RepositoryLinksResource process(RepositoryLinksResource linksResource) {

        return linksResource;
    }
}
